package ir.maktab.homeservice.mapper.order;

import ir.maktab.homeservice.domain.model.order.OrderModel;
import ir.maktab.homeservice.dto.order.OrderDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import ir.maktab.homeservice.mapper.service.SubServiceMapper;
import ir.maktab.homeservice.mapper.user.CustomerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {SubServiceMapper.class, CustomerMapper.class})
public abstract class OrderMapper extends AbstractMapper<OrderModel, OrderDto, Long> {

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "subServiceId", source = "subService.id")
    public abstract OrderDto mapToDto(OrderModel model);

    @Mapping(target = "subService", source = "subServiceId")
    @Mapping(target = "customer", source = "customerId")
    public abstract OrderModel mapToModel(OrderDto dto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "subServiceId", source = "subService.id")
    public abstract void updateDtoByModel(@MappingTarget OrderDto dto, OrderModel model);

    @Mapping(target = "subService", source = "subServiceId")
    @Mapping(target = "customer", source = "customerId")
    public abstract void updateModelByDto(@MappingTarget OrderModel model, OrderDto dto);

}
