package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.mapper.order.OrderMapper;
import ir.maktab.homeserviceprovider.mapper.user.ExpertMapper;
import ir.maktab.homeserviceprovider.repository.user.ExpertRepository;
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

    private final ExpertMapper expertMapper;
    private final OrderMapper orderMapper;

    public ExpertService(ExpertRepository repository, ExpertMapper expertMapper, OrderMapper orderMapper) {
        super(repository, expertMapper);
        this.repository = repository;
        this.expertMapper = expertMapper;
        this.orderMapper = orderMapper;
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

    @Override
    @Transactional(readOnly = true)
    public Page<ExpertDto> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(ExpertSpecifications.withFirstname(searchParam.getFirstname())
                                .and(ExpertSpecifications.withLastname(searchParam.getLastname()))
                                .and(ExpertSpecifications.withStatus(searchParam.getStatus()))
                                .and(ExpertSpecifications.withServiceId(searchParam.getServiceId()))
                        , pageable)
                .map(expertMapper::mapToDto);
    }
}
