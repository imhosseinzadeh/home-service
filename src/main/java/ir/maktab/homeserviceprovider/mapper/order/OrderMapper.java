package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    @Mappings({
            @Mapping(target = "customerId", source = "customer.id"),
            @Mapping(target = "subServiceId", source = "subService.id")
    })
    public abstract OrderDto mapToDto(OrderModel model);

    public abstract OrderModel mapToModel(OrderDto dto);

    @Mappings({
            @Mapping(target = "customerId", source = "customer.id"),
            @Mapping(target = "subServiceId", source = "subService.id")
    })
    public abstract void updateDtoByModel(@MappingTarget OrderDto dto, OrderModel model);

    public abstract void updateModelByDto(@MappingTarget OrderModel model, OrderDto dto);

}
