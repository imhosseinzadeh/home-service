package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.order.OrderModelStatus;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService extends BaseService<OrderModel, OrderDto, Long> {

    private final OrderRepository repository;

    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
        this.repository = orderRepository;
    }

    @Override
    public Optional<OrderDto> save(OrderDto dto) {
        dto.setStatus(OrderModelStatus.WAITING_FOR_EXPERTS_SUGGESTIONS);
        OrderModel savedModel = repository.save(mapToModel(dto));
        return Optional.ofNullable(mapToDto(savedModel));
    }

    @Override
    protected Class<OrderModel> getModelClass() {
        return OrderModel.class;
    }

    @Override
    protected Class<OrderDto> getDtoClass() {
        return OrderDto.class;
    }

}
