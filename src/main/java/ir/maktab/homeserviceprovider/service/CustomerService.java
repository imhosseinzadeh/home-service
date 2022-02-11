package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.CustomerModel;
import ir.maktab.homeserviceprovider.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends UserService<CustomerModel> {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
        this.repository = customerRepository;
    }
}
