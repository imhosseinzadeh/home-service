package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class OfferMapper {

    @Mappings({
            @Mapping(target = "expertId", source = "expert.id"),
            @Mapping(target = "orderId", source = "order.id")
    })
    public abstract OfferDto mapToDto(OfferModel model);

    @Mappings({
            @Mapping(target = "expert.id", source = "expertId"),
            @Mapping(target = "order.id", source = "orderId")
    })
    public abstract OfferModel mapToModel(OfferDto dto);

    @Mappings({
            @Mapping(target = "expertId", source = "expert.id"),
            @Mapping(target = "orderId", source = "order.id")
    })
    public abstract void updateDtoByModel(@MappingTarget OfferDto dto, OfferModel model);

    @Mappings({
            @Mapping(target = "expert.id", source = "expertId"),
            @Mapping(target = "order.id", source = "orderId")
    })
    public abstract void updateModelByDto(@MappingTarget OfferModel model, OfferDto dto);

}
