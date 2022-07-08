package ir.maktab.homeservice.repository.user;

import ir.maktab.homeservice.domain.model.order.OrderModel;

import java.util.List;

public interface ExpertRepositoryCustom {
    List<OrderModel> getRelatedOrder(Long id);
}
