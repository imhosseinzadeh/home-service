package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.mapper.order.OrderMapper;
import ir.maktab.homeserviceprovider.mapper.service.ServiceMapper;
import ir.maktab.homeserviceprovider.mapper.user.ExpertMapper;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import ir.maktab.homeserviceprovider.repository.user.ExpertRepository;
import ir.maktab.homeserviceprovider.repository.user.UserRepository;
import ir.maktab.homeserviceprovider.specification.ExpertSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpertService extends UserService<ExpertModel, ExpertDto> {

    private final ExpertRepository repository;
    private final ExpertServiceRepository expertServiceRepository;

    private final ServiceMapper serviceMapper;
    private final ExpertMapper expertMapper;
    private final OrderMapper orderMapper;

    public ExpertService(UserRepository<ExpertModel> userRepository,
                         ExpertRepository repository, ExpertServiceRepository expertServiceRepository,
                         ExpertMapper expertMapper, ServiceMapper serviceMapper, OrderMapper orderMapper) {
        super(userRepository);
        this.repository = repository;
        this.expertServiceRepository = expertServiceRepository;
        this.expertMapper = expertMapper;
        this.serviceMapper = serviceMapper;
        this.orderMapper = orderMapper;
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getRelatedOrders(Long id, Pageable pageable) {
        List<OrderModel> relatedOrder = repository.getRelatedOrder(id);
        List<OrderDto> resultDto = new ArrayList<>();
        for (OrderModel orderModel : relatedOrder) {
            OrderDto orderDto = this.orderMapper.mapToDto(orderModel);
            resultDto.add(orderDto);
        }
        return resultDto;
    }


    @Transactional(readOnly = true)
    public Page<ServiceModel> findServicesByExpert(ExpertModel expert, Pageable pageable) {
        Page<ExpertServiceModel> allByExpert = expertServiceRepository.findAllByExpert(expert, pageable);
        return allByExpert.map(ExpertServiceModel::getService);
    }

    @Transactional(readOnly = true)
    public Page<ExpertModel> findExpertsByService(ServiceModel service, Pageable pageable) {
        Page<ExpertServiceModel> allByService = expertServiceRepository.findAllByService(service, pageable);
        return allByService.map(ExpertServiceModel::getExpert);
    }

    @Override
    protected ExpertDto mapToDto(ExpertModel model) {
        return null;
    }

    @Override
    protected ExpertModel mapToModel(ExpertDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(ExpertDto dto, ExpertModel model) {

    }

    @Override
    public Page<ExpertDto> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(ExpertSpecifications.withFirstname(searchParam.getFirstname())
                                .and(ExpertSpecifications.withLastname(searchParam.getLastname()))
                                .and(ExpertSpecifications.withStatus(searchParam.getStatus()))
                                .and(ExpertSpecifications.withServiceId(searchParam.getServiceId()))
                        , pageable)
                .map(this::mapToDto);
    }
}
