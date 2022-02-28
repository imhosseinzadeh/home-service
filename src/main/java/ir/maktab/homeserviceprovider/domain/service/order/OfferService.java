package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.mapper.order.OfferMapper;
import ir.maktab.homeserviceprovider.repository.order.OfferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OfferService extends BaseService<OfferModel, OfferDto, Long> {

    private final OfferRepository repository;
    private final OrderService orderService;

    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, OrderService orderService, OfferMapper offerMapper) {
        super(offerRepository);
        this.repository = offerRepository;
        this.orderService = orderService;
        this.offerMapper = offerMapper;
    }

    @Override
    public OfferDto save(OfferDto dto) {
        Optional<OrderDto> optOrder = this.orderService.findById(dto.getOrderId());
        if (optOrder.isPresent()) {
            BigDecimal orderPrice = optOrder.get().getProposedPrice();
            BigDecimal offerPrice = dto.getProposalPrice();

            if (offerPrice.compareTo(orderPrice) > 0) {
                OfferModel saved = this.repository.save(this.offerMapper.mapToModel(dto));
                return this.offerMapper.mapToDto(saved);
            }
            //throw LesserPriceException();
        }
        return null;
    }

    @Override
    protected OfferDto mapToDto(OfferModel model) {
        return null;
    }

    @Override
    protected OfferModel mapToModel(OfferDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(OfferDto dto, OfferModel model) {

    }
}
