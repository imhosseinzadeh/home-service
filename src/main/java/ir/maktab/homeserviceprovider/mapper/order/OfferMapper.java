package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "orderId", source = "order.id")
    OfferDto mapToDto(OfferModel model);

    @Mapping(target = "expert.id", source = "expertId")
    @Mapping(target = "order.id", source = "orderId")
    OfferModel mapToModel(OfferDto dto);

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "orderId", source = "order.id")
    void updateDtoByModel(@MappingTarget OfferDto dto, OfferModel model);

    @Mapping(target = "expert.id", source = "expertId")
    @Mapping(target = "order.id", source = "orderId")
    void updateModelByDto(@MappingTarget OfferModel model, OfferDto dto);
}
