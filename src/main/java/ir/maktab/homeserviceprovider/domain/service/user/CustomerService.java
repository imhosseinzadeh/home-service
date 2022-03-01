package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.mapper.order.OrderMapper;
import ir.maktab.homeserviceprovider.mapper.user.CustomerMapper;
import ir.maktab.homeserviceprovider.repository.user.CustomerRepository;
import ir.maktab.homeserviceprovider.specification.CustomerSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService extends UserService<CustomerModel, CustomerDto> {

    private final CustomerRepository repository;
    private final CustomerMapper customerMapper;
    private final OrderMapper orderMapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper, OrderMapper orderMapper) {
        super(repository, mapper);
        this.repository = repository;
        this.customerMapper = mapper;
        this.orderMapper = orderMapper;
    }

    @Transactional(readOnly = true)
    public Set<OrderDto> ordersHistory(Long customerId) throws DataNotExistsException {
        Optional<CustomerModel> optCustomer = this.repository.findById(customerId);
        if (optCustomer.isPresent()) {
            Set<OrderModel> customerOrders = optCustomer.get().getOrders();
            return orderMapper.mapToDto(customerOrders);
        }
        throw new DataNotExistsException();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDto> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(CustomerSpecifications.withFirstname(searchParam.getFirstname())
                                .and(CustomerSpecifications.withLastname(searchParam.getLastname()))
                                .and(CustomerSpecifications.withStatus(searchParam.getStatus()))
                        , pageable)
                .map(customerMapper::mapToDto);
    }

}
