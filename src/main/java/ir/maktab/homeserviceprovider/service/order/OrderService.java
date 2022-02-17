package ir.maktab.homeserviceprovider.service.order;

import ir.maktab.homeserviceprovider.model.order.OrderModel;
import ir.maktab.homeserviceprovider.repository.order.OrderRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderModel, Long> {

    private final OrderRepository repository;

    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
        this.repository = orderRepository;
    }
}