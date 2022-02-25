package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;

import java.util.List;

public interface ExpertRepositoryCustom {
    List<OrderModel> getRelatedOrder(ExpertModel expertModel);
}
