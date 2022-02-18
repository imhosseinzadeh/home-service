package ir.maktab.homeserviceprovider.service.user;

import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.repository.user.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends UserService<CustomerModel, CustomerDto> {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
        this.repository = customerRepository;
    }

    @Override
    protected Class<CustomerModel> getModelClass() {
        return CustomerModel.class;
    }

}
