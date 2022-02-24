package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.mapper.user.CustomerMapper;
import ir.maktab.homeserviceprovider.repository.user.CustomerRepository;
import ir.maktab.homeserviceprovider.repository.user.CustomerSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends UserService<CustomerModel, CustomerDto> {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final CustomerSpecifications specifications;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper mapper, CustomerSpecifications specifications) {
        super(customerRepository, specifications);
        this.repository = customerRepository;
        this.mapper = mapper;
        this.specifications = specifications;
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

    @Override
    public Page<CustomerModel> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(Specification.where(this.specifications
                .withFirstname(searchParam.getFirstname())
                .and(specifications.withLastname(searchParam.getLastname()))), pageable);
    }

}
