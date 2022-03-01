package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import ir.maktab.homeserviceprovider.mapper.user.ExpertMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ExpertMapper.class, OrderMapper.class})
public abstract class OfferMapper extends AbstractGenericMapper<OfferModel, Long> {

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "orderId", source = "order.id")
    public abstract OfferDto mapToDto(OfferModel model);

    @Mapping(target = "expert", source = "expertId")
    @Mapping(target = "order", source = "orderId")
    public abstract OfferModel mapToModel(OfferDto dto);

    public abstract Set<OfferDto> mapToDto(Set<OfferModel> models);

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "orderId", source = "order.id")
    public abstract void updateDtoByModel(@MappingTarget OfferDto dto, OfferModel model);

    @Mapping(target = "expert", source = "expertId")
    @Mapping(target = "order", source = "orderId")
    public abstract void updateModelByDto(@MappingTarget OfferModel model, OfferDto dto);

}
