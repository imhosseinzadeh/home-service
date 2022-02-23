package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
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
    protected CustomerDto mapToDto(CustomerModel model) {
        return null;
    }

    @Override
    protected CustomerModel mapToModel(CustomerDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(CustomerDto dto, CustomerModel model) {

    }
}
