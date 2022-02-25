package ir.maktab.homeserviceprovider.repository.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;

import java.util.List;

public interface OrderRepositoryCustom {
    List<OrderModel> relatedOrder(ExpertModel expertModel);
}
