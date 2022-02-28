package ir.maktab.homeserviceprovider.domain.service;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
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

    protected abstract D mapToDto(M model);

    protected abstract M mapToModel(D dto);

    protected abstract void updateModelByDto(D dto, M model);

    @Transactional
    public D save(D dto) {
        M savedModel = jpaRepository.save(mapToModel(dto));
        return mapToDto(savedModel);
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
            updateModelByDto(dto, loadedModel);
            this.jpaRepository.save(loadedModel);
            return Optional.of(mapToDto(loadedModel));
        }
        return Optional.empty();
    }

    @Transactional
    public void delete(D dto) {
        jpaRepository.delete(mapToModel(dto));
    }

    @Transactional
    public void deleteById(I id) throws DataNotExistsException {
        if (existsById(id)) {
            jpaRepository.deleteById(id);
        }
    }

    @Transactional(readOnly = true)
    public Optional<D> findById(I id) {
        return jpaRepository.findById(id).map(this::mapToDto);
    }

    @Transactional(readOnly = true)
    public Page<D> findAllByPage(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(this::mapToDto);
    }

    @Transactional(readOnly = true)
    public boolean existsById(I id) throws DataNotExistsException {
        if (jpaRepository.existsById(id)) {
            return true;
        }
        throw new DataNotExistsException();
    }

}
