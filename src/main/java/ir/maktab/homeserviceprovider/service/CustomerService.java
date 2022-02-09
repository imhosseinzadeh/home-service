package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.Customer;
import ir.maktab.homeserviceprovider.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer, Long> {

    private final CustomerRepository repository;

    /*@Autowired//not necessary*/
    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
        this.repository = customerRepository;
    }
}