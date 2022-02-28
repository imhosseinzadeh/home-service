package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import ir.maktab.homeserviceprovider.mapper.service.SubServiceMapper;
import ir.maktab.homeserviceprovider.mapper.user.CustomerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {SubServiceMapper.class, CustomerMapper.class})
public abstract class OrderMapper extends AbstractGenericMapper<OrderModel, Long> {

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
