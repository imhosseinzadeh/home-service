package ir.maktab.homeserviceprovider.mapper.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto mapToDto(OrderModel model);

    OrderModel mapToModel(OrderDto dto);

    void updateDtoByModel(@MappingTarget OrderDto dto, OrderModel model);

    void updateModelByDto(@MappingTarget OrderModel model, OrderDto dto);

}
