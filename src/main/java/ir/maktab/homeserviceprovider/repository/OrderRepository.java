package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
