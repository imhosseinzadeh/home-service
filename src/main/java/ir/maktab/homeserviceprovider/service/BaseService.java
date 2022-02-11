package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.BaseModel;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.*;

import java.io.Serializable;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseService<M extends BaseModel<I>, I extends Serializable> {

    private final JpaRepository<M, I> jpaRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public M saveOrUpdate(M model) {
        return jpaRepository.save(model);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<M> saveAll(Iterable<M> models) {
        return jpaRepository.saveAll(models);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(M model) {
        jpaRepository.delete(model);
    }

    @Transactional(readOnly = true)
    public Optional<M> load(I id) {
        return jpaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<M> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public boolean contains(Example<M> entity) {
        return jpaRepository.exists(entity);
    }

    @Transactional(readOnly = true)
    public boolean existsById(I id) {
        return jpaRepository.existsById(id);
    }
}
