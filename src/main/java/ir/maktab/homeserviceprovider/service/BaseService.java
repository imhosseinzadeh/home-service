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
public class BaseService<E extends BaseModel<I>, I extends Serializable> {

    private final JpaRepository<E, I> jpaRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public E saveOrUpdate(E entity) {
        return jpaRepository.save(entity);
    }

    public Iterable<E> saveAll(Iterable<E> models) {
        return jpaRepository.saveAll(models);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void delete(E entity) {
        jpaRepository.delete(entity);
    }

    @Transactional(readOnly = true)
    public Optional<E> load(I id) {
        return jpaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<E> getPage(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<E> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public boolean contains(Example<E> entity) {
        return jpaRepository.exists(entity);
    }

    @Transactional(readOnly = true)
    public boolean existsById(I id) {
        return jpaRepository.existsById(id);
    }
}
