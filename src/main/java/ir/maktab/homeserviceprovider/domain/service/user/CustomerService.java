package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.mapper.user.CustomerMapper;
import ir.maktab.homeserviceprovider.repository.user.CustomerRepository;
import ir.maktab.homeserviceprovider.specification.CustomerSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends UserService<CustomerModel, CustomerDto> {

    private final CustomerRepository repository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.customerMapper = mapper;
    }

    @Override
    public Page<CustomerDto> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(CustomerSpecifications.withFirstname(searchParam.getFirstname())
                                .and(CustomerSpecifications.withLastname(searchParam.getLastname()))
                                .and(CustomerSpecifications.withStatus(searchParam.getStatus()))
                        , pageable)
                .map(customerMapper::mapToDto);
    }

}
