package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.model.user.CustomerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends UserRepository<CustomerModel> {
}
