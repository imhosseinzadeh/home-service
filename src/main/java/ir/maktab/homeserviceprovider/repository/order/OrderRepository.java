package ir.maktab.homeserviceprovider.repository.order;

import ir.maktab.homeserviceprovider.model.order.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
