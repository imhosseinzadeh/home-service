package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends UserRepository<Customer> {
}