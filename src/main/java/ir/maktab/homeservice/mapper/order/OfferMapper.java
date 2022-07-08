package ir.maktab.homeservice.mapper.order;

import ir.maktab.homeservice.domain.model.order.OfferModel;
import ir.maktab.homeservice.dto.order.OfferDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import ir.maktab.homeservice.mapper.user.ExpertMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ExpertMapper.class, OrderMapper.class})
public abstract class OfferMapper extends AbstractMapper<OfferModel, OfferDto, Long> {

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "orderId", source = "order.id")
    public abstract OfferDto mapToDto(OfferModel model);

    @Mapping(target = "expert", source = "expertId")
    @Mapping(target = "order", source = "orderId")
    public abstract OfferModel mapToModel(OfferDto dto);

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "orderId", source = "order.id")
    public abstract void updateDtoByModel(@MappingTarget OfferDto dto, OfferModel model);

    @Mapping(target = "expert", source = "expertId")
    @Mapping(target = "order", source = "orderId")
    public abstract void updateModelByDto(@MappingTarget OfferModel model, OfferDto dto);

}
