package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
