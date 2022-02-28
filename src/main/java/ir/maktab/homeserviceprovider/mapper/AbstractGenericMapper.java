package ir.maktab.homeserviceprovider.mapper;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import ir.maktab.homeserviceprovider.dto.BaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public abstract class AbstractGenericMapper<M extends BaseModel<I>, D extends BaseDto<I>, I extends Serializable>
        implements GenericMapper<M, D> {

    @Autowired
    private JpaRepository<M, I> jpaRepository;

    protected M map(I id) {
        if (id == null) {
            return null;
        }

        return this.jpaRepository.findById(id)
                .orElse(null);
    }

}
