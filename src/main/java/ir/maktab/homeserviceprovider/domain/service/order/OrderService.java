package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.mapper.order.OfferMapper;
import ir.maktab.homeserviceprovider.mapper.order.OrderMapper;
import ir.maktab.homeserviceprovider.repository.order.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderService extends BaseService<OrderModel, OrderDto, Long> {

    private final OrderRepository repository;
    private final OfferService offerService;

    private final OrderMapper orderMapper;
    private final OfferMapper offerMapper;

    public OrderService(OrderRepository repository, OfferService offerService, OrderMapper orderMapper, OfferMapper offerMapper) {
        super(repository, orderMapper);
        this.repository = repository;
        this.offerService = offerService;
        this.orderMapper = orderMapper;
        this.offerMapper = offerMapper;
    }

    @Transactional(readOnly = true)
    public Set<OfferDto> getOrderOffers(Long id) {
        Optional<OrderModel> optOrder = this.repository.findById(id);
        if (optOrder.isPresent()) {
            Set<OfferModel> orderOffers = optOrder.get().getOffers();
            return this.offerMapper.mapToDto(orderOffers);
        }
        return null;
    }

    @Transactional
    public void acceptOffer(Long orderId, Long offerId) throws DataNotExistsException {
        Optional<OrderModel> optOrder = this.repository.findById(orderId);
        Optional<OfferDto> optOffer = this.offerService.findById(offerId);
        if (optOrder.isPresent() && optOffer.isPresent()) {
            OrderModel order = optOrder.get();
            OfferModel offer = this.offerMapper.mapToModel(optOffer.get());
            order.setAcceptedOffer(offer);
            this.repository.save(order);
        }
        throw new DataNotExistsException();
    }

}
