package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.Order;
import ir.maktab.homeserviceprovider.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order, Long> {

    private final OrderRepository repository;

    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
        this.repository = orderRepository;
    }
}
