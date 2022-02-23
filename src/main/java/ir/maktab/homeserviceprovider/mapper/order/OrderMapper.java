package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "customerId", expression = "java(model.getCustomer().getId())")
    @Mapping(target = "subServiceId", expression = "java(model.getSubService().getId())")
    OrderDto mapToDto(OrderModel model);

    OrderModel mapToModel(OrderDto dto);

    @Mapping(target = "customerId", expression = "java(model.getCustomer().getId())")
    @Mapping(target = "subServiceId", expression = "java(model.getSubService().getId())")
    void updateDtoByModel(@MappingTarget OrderDto dto, OrderModel model);

    void updateModelByDto(@MappingTarget OrderModel model, OrderDto dto);

}
