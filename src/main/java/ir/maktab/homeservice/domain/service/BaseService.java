package ir.maktab.homeservice.domain.service;

import ir.maktab.homeservice.domain.model.BaseModel;
import ir.maktab.homeservice.dto.BaseDto;
import ir.maktab.homeservice.exception.DataNotExistsException;
import ir.maktab.homeservice.mapper.AbstractMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseService<M extends BaseModel<I>, D extends BaseDto<I>, I extends Serializable> {

    private final JpaRepository<M, I> jpaRepository;
    private final AbstractMapper<M, D, I> mapper;

    @Transactional
    public D save(D dto) {
        M savedModel = jpaRepository.save(mapper.mapToModel(dto));
        return mapper.mapToDto(savedModel);
    }

    @Transactional
    public void saveAll(Iterable<D> dIterable) {
        dIterable.forEach(this::save);
    }

    @Transactional
    public Optional<D> update(D dto) {
        Optional<M> optModel = this.jpaRepository.findById(dto.getId());

        if (optModel.isPresent()) {
            M loadedModel = optModel.get();
            mapper.updateModelByDto(loadedModel, dto);

            this.jpaRepository.save(loadedModel);
            return Optional.of(mapper.mapToDto(loadedModel));
        }

        return Optional.empty();
    }

    @Transactional
    public void delete(D dto) {
        jpaRepository.delete(mapper.mapToModel(dto));
    }

    @Transactional
    public void deleteById(I id) throws DataNotExistsException {
        if (existsById(id)) {
            jpaRepository.deleteById(id);
        }
    }

    @Transactional(readOnly = true)
    public Optional<D> findById(I id) {
        return jpaRepository.findById(id).map(mapper::mapToDto);
    }

    @Transactional(readOnly = true)
    public Page<D> findAllByPage(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::mapToDto);
    }

    @Transactional(readOnly = true)
    public boolean existsById(I id) throws DataNotExistsException {
        if (jpaRepository.existsById(id)) {
            return true;
        }
        throw new DataNotExistsException();
    }

}
