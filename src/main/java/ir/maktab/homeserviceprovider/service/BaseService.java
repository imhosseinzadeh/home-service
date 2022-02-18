package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.model.BaseModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseService<M extends BaseModel<I>, D extends BaseDto<I>, I extends Serializable> {

    private final JpaRepository<M, I> jpaRepository;
    protected final ModelMapper mapper = new ModelMapper();

    protected abstract Class<M> getModelClass();

    @Transactional(propagation = Propagation.REQUIRED)
    public M save(D dto) {
        M model = this.mapper.map(dto, getModelClass());
        return jpaRepository.save(model);
    }

    public M update(D dto) {
        M model = this.mapper.map(dto, getModelClass());
        return jpaRepository.save(model);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<M> saveAll(Iterable<D> dtoIterable) {
        Iterable<M> mIterable = this.mapper.<List<M>>map(dtoIterable, getModelClass());
        return jpaRepository.saveAll(mIterable);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(D dto) {
        M model = this.mapper.map(dto, getModelClass());
        jpaRepository.delete(model);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(I id) {
        jpaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<M> load(I id) {
        return jpaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<M> findAllByPage(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public boolean contains(Example<M> modelExample) {
        return jpaRepository.exists(modelExample);
    }

    @Transactional(readOnly = true)
    public boolean existsById(I id) {
        return jpaRepository.existsById(id);
    }

}
