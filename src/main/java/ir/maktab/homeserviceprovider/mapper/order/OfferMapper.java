package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.repository.order.OrderRepository;
import ir.maktab.homeserviceprovider.repository.user.ExpertRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OfferMapper {

    @Autowired
    protected ExpertRepository expertRepository;
    @Autowired
    protected OrderRepository orderRepository;

    @Mappings({
            @Mapping(target = "expertId", source = "expert.id"),
            @Mapping(target = "orderId", source = "order.id")
    })
    public abstract OfferDto mapToDto(OfferModel model);

    @Mappings({
            @Mapping(target = "expert", expression = "java(expertRepository.getById(dto.getExpertId()))"),
            @Mapping(target = "order", expression = "java(orderRepository.getById(dto.getOrderId()))")
    })
    public abstract OfferModel mapToModel(OfferDto dto) throws DataNotExistsException;

    @Mappings({
            @Mapping(target = "expertId", source = "expert.id"),
            @Mapping(target = "orderId", source = "order.id")
    })
    public abstract void updateDtoByModel(@MappingTarget OfferDto dto, OfferModel model);

    @Mappings({
            @Mapping(target = "expert", expression = "java(expertRepository.getById(dto.getExpertId()))"),
            @Mapping(target = "order", expression = "java(orderRepository.getById(dto.getOrderId()))")
    })
    public abstract void updateModelByDto(@MappingTarget OfferModel model, OfferDto dto);

}
