package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.mapper.order.OrderMapper;
import ir.maktab.homeserviceprovider.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderModel, OrderDto, Long> {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderService(OrderRepository orderRepository, OrderMapper mapper) {
        super(orderRepository);
        this.repository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    protected OrderDto mapToDto(OrderModel model) {
        return this.mapper.mapToDto(model);
    }

    @Override
    protected OrderModel mapToModel(OrderDto dto) {
        return this.mapper.mapToModel(dto);
    }

    @Override
    protected void updateModelByDto(OrderDto dto, OrderModel model) {
        this.mapper.updateModelByDto(model, dto);
    }

}
