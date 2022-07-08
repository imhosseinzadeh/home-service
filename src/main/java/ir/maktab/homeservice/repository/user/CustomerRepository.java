package ir.maktab.homeservice.repository.user;

import ir.maktab.homeservice.domain.model.user.CustomerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends UserRepository<CustomerModel> {
}
