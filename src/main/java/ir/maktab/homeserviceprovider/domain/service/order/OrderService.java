package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.mapper.order.OfferMapper;
import ir.maktab.homeserviceprovider.mapper.order.OrderMapper;
import ir.maktab.homeserviceprovider.repository.order.OfferRepository;
import ir.maktab.homeserviceprovider.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderService extends BaseService<OrderModel, OrderDto, Long> {

    private final OrderRepository repository;
    private final OfferRepository offerRepository;
    private final OrderMapper mapper;
    private final OfferMapper offerMapper;

    public OrderService(OrderRepository orderRepository, OfferRepository offerRepository, OrderMapper mapper, OfferMapper offerMapper) {
        super(orderRepository);
        this.repository = orderRepository;
        this.offerRepository = offerRepository;
        this.mapper = mapper;
        this.offerMapper = offerMapper;
    }

    public Set<OfferDto> getOrderOffers(Long id) {
        Optional<OrderModel> optOrder = this.repository.findById(id);
        if (optOrder.isPresent()) {
            Set<OfferModel> orderOffers = optOrder.get().getOffers();
            return this.offerMapper.mapToDto(orderOffers);
        }
        return null;
    }

    public void acceptOffer(Long orderId, Long offerId) throws DataNotExistsException {
        Optional<OrderModel> optOrder = this.repository.findById(orderId);
        Optional<OfferModel> optOffer = this.offerRepository.findById(offerId);
        if (optOrder.isPresent() && optOffer.isPresent()) {
            OrderModel order = optOrder.get();
            OfferModel offer = optOffer.get();
            order.setAcceptedOffer(offer);
            this.repository.save(order);
        }
        throw new DataNotExistsException();
    }

    @Override
    protected OrderDto mapToDto(OrderModel model) {
        return this.mapper.mapToDto(model);
    }

    @Override
    protected OrderModel mapToModel(OrderDto dto) {
        return this.mapper.mapToModel(dto);
    }

    @Override
    protected void updateModelByDto(OrderDto dto, OrderModel model) {
        this.mapper.updateModelByDto(model, dto);
    }

}
