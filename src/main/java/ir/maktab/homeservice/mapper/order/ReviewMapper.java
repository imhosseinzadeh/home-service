package ir.maktab.homeservice.mapper.order;

import ir.maktab.homeservice.domain.model.order.ReviewModel;
import ir.maktab.homeservice.dto.order.ReviewDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import ir.maktab.homeservice.mapper.user.CustomerMapper;
import ir.maktab.homeservice.mapper.user.ExpertMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ExpertMapper.class})
public abstract class ReviewMapper extends AbstractMapper<ReviewModel, ReviewDto, Long> {

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "expertId", source = "expert.id")
    public abstract ReviewDto mapToDto(ReviewModel model);

    @Mapping(target = "customer", source = "customerId")
    @Mapping(target = "expert", source = "expertId")
    public abstract ReviewModel mapToModel(ReviewDto dto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "expertId", source = "expert.id")
    public abstract void updateDtoByModel(@MappingTarget ReviewDto dto, ReviewModel model);

    @Mapping(target = "customer", source = "customerId")
    @Mapping(target = "expert", source = "expertId")
    public abstract void updateModelByDto(@MappingTarget ReviewModel model, ReviewDto dto);

}
