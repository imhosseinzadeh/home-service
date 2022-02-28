package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.domain.service.service.ExpertServiceService;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.dto.service.ExpertServiceDto;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.mapper.order.OrderMapper;
import ir.maktab.homeserviceprovider.mapper.service.ServiceMapper;
import ir.maktab.homeserviceprovider.mapper.user.ExpertMapper;
import ir.maktab.homeserviceprovider.mapper.user.ExpertServiceMapper;
import ir.maktab.homeserviceprovider.repository.user.ExpertRepository;
import ir.maktab.homeserviceprovider.specification.ExpertSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpertService extends UserService<ExpertModel, ExpertDto> {

    private final ExpertRepository repository;
    private final ExpertServiceService expertServiceService;

    private final ServiceMapper serviceMapper;
    private final ExpertMapper expertMapper;
    private final OrderMapper orderMapper;
    private final ExpertServiceMapper expertServiceMapper;

    public ExpertService(ExpertRepository repository, ExpertServiceService expertServiceService,
                         ServiceMapper serviceMapper, ExpertMapper expertMapper, OrderMapper orderMapper, ExpertServiceMapper expertServiceMapper) {
        super(repository);
        this.repository = repository;
        this.expertServiceService = expertServiceService;
        this.serviceMapper = serviceMapper;
        this.expertMapper = expertMapper;
        this.orderMapper = orderMapper;
        this.expertServiceMapper = expertServiceMapper;
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getRelatedOrders(Long id) {
        List<OrderModel> relatedOrder = repository.getRelatedOrder(id);
        List<OrderDto> resultDto = new ArrayList<>();
        for (OrderModel orderModel : relatedOrder) {
            OrderDto orderDto = this.orderMapper.mapToDto(orderModel);
            resultDto.add(orderDto);
        }
        return resultDto;
    }

    @Transactional
    public Optional<ExpertServiceDto> addService(Long expertId, ServiceDto serviceDto) throws DataNotExistsException {
        Optional<ExpertDto> optFind = findById(expertId);
        if (optFind.isPresent()) {
            ExpertModel expert = mapToModel(optFind.get());
            ServiceModel service = this.serviceMapper.mapToModel(serviceDto);
            ExpertServiceModel expertService = ExpertServiceModel.builder()
                    .expert(expert)
                    .service(service)
                    .build();
            return this.expertServiceService.save(this.expertServiceMapper.mapToDto(expertService));
        } else {
            throw new DataNotExistsException("Expert with id: " + expertId + "not found");
        }
    }

    @Transactional(readOnly = true)
    public Page<ServiceModel> findServicesByExpert(ExpertModel expert, Pageable pageable) {
        Page<ExpertServiceModel> allByExpert = expertServiceService.findAllByExpert(expert, pageable);
        return allByExpert.map(ExpertServiceModel::getService);
    }

    @Transactional(readOnly = true)
    public Page<ExpertModel> findExpertsByService(ServiceModel service, Pageable pageable) {
        Page<ExpertServiceModel> allByService = expertServiceService.findAllByService(service, pageable);
        return allByService.map(ExpertServiceModel::getExpert);
    }

    @Override
    protected ExpertDto mapToDto(ExpertModel model) {
        return this.expertMapper.mapToDto(model);
    }

    @Override
    protected ExpertModel mapToModel(ExpertDto dto) {
        return this.expertMapper.mapToModel(dto);
    }

    @Override
    protected void updateModelByDto(ExpertDto dto, ExpertModel model) {
        this.expertMapper.updateModelByDto(model, dto);
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
