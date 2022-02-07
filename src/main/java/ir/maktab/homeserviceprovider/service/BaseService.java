package ir.maktab.homeserviceprovider.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseService<E, I extends Serializable> {

    private final JpaRepository<E, I> jpaRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void saveOrUpdate(E entity) {
        jpaRepository.save(entity);
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
    public List<E> findAll() {
        return jpaRepository.findAll();
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
