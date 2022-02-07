package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.Customer;
import ir.maktab.homeserviceprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer, Long> {

    private final CustomerRepository repository;

    @Autowired//not necessary
    public CustomerService(CustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }
}