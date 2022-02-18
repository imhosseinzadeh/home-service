package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.exception.UserNotFoundException;
import ir.maktab.homeserviceprovider.model.BaseModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseService<M extends BaseModel<I>, D extends BaseDto<I>, I extends Serializable> {

    private final JpaRepository<M, I> jpaRepository;
    protected final ModelMapper mapper = new ModelMapper();

    protected abstract Class<M> getModelClass();

    protected abstract Class<D> getDtoClass();

    protected D mapToDto(M model) {
        return this.mapper.map(model, getDtoClass());
    }

    protected M mapToModel(D dto) {
        return this.mapper.map(dto, getModelClass());
    }

    @Transactional
    public Optional<D> save(D dto) {
        M savedModel = jpaRepository.save(mapToModel(dto));
        return Optional.ofNullable(mapToDto(savedModel));
    }

    @Transactional
    public Optional<List<D>> saveAll(Iterable<D> dIterable) {
        Iterable<M> mIterable = this.mapper.<List<M>>map(dIterable, getModelClass());
        List<M> mList = jpaRepository.saveAll(mIterable);
        return Optional.ofNullable(this.mapper.<List<D>>map(mList, getDtoClass()));
    }

    @Transactional
    public Optional<D> update(D dto) {
        Optional<M> optModel = this.jpaRepository.findById(dto.getId());
        if (optModel.isPresent()) {
            M loadedModel = optModel.get();
            this.mapper.map(dto, loadedModel);
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
    public void deleteById(I id) throws UserNotFoundException {
        if (existsById(id)) {
            jpaRepository.deleteById(id);
            return;
        }
        throw new UserNotFoundException();
    }

    @Transactional(readOnly = true)
    public Optional<D> load(I id) {
        return jpaRepository.findById(id).map(this::mapToDto);
    }

    @Transactional(readOnly = true)
    public Page<D> findAllByPage(Pageable pageable) {
        Page<M> modelPage = jpaRepository.findAll(pageable);
        return this.mapper.<Page<D>>map(modelPage, getDtoClass());
    }

    @Transactional(readOnly = true)
    public boolean existsById(I id) {
        return jpaRepository.existsById(id);
    }

}
