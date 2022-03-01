package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.order.OrderModelStatus;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.mapper.order.OfferMapper;
import ir.maktab.homeserviceprovider.repository.order.OfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OfferService extends BaseService<OfferModel, OfferDto, Long> {

    private final OfferRepository repository;

    private final OfferMapper offerMapper;

    public OfferService(OfferRepository repository, OfferMapper offerMapper) {
        super(repository, offerMapper);
        this.repository = repository;
        this.offerMapper = offerMapper;
    }

    @Override
    @Transactional
    public OfferDto save(OfferDto dto) {
        OfferModel offer = this.offerMapper.mapToModel(dto);
        OrderModel order = offer.getOrder();

        BigDecimal offerPrice = offer.getProposalPrice();
        BigDecimal orderPrice = order.getProposedPrice();

        if (offerPrice.compareTo(orderPrice) > 0) {
            order.setStatus(OrderModelStatus.WAIT_FOR_ACCEPT_EXPERT_OFFER);
            OfferModel saved = this.repository.save(offer);
            return this.offerMapper.mapToDto(saved);
        }
        //throw LesserPriceException();
        return null;
    }

}
