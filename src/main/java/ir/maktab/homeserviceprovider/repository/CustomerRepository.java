package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.CustomerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends UserRepository<CustomerModel> {
}
