package ir.maktab.homeserviceprovider.mapper;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public abstract class AbstractGenericMapper<M extends BaseModel<I>, I extends Serializable> {

    private JpaRepository<M, I> jpaRepository;

    public M findModelById(I id) {
        if (id == null) {
            return null;
        }

        return this.jpaRepository.findById(id)
                .orElse(null);
    }

    @Autowired
    public void setJpaRepository(JpaRepository<M, I> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

}
