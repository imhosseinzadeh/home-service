package ir.maktab.homeservice.mapper;

import ir.maktab.homeservice.domain.model.BaseModel;
import ir.maktab.homeservice.dto.BaseDto;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

@Component
public abstract class AbstractMapper<M extends BaseModel<I>, D extends BaseDto<I>, I extends Serializable> {

    private JpaRepository<M, I> jpaRepository;

    public abstract D mapToDto(M model);

    public abstract M mapToModel(D dto);

    public abstract Set<D> mapToDto(Set<M> models);

    public abstract Set<M> mapToModel(Set<D> models);

    public abstract void updateDtoByModel(@MappingTarget D dto, M model);

    public abstract void updateModelByDto(@MappingTarget M model, D dto);

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
