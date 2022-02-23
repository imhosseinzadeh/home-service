package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.mapper.user.CustomerMapper;
import ir.maktab.homeserviceprovider.repository.user.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends UserService<CustomerModel, CustomerDto> {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper mapper) {
        super(customerRepository);
        this.repository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    protected CustomerDto mapToDto(CustomerModel model) {
        return this.mapper.mapToDto(model);
    }

    @Override
    protected CustomerModel mapToModel(CustomerDto dto) {
        return this.mapper.mapToModel(dto);
    }

    @Override
    protected void updateModelByDto(CustomerDto dto, CustomerModel model) {
        this.mapper.updateModelByDto(model, dto);
    }
}
