package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.OfferModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.repository.order.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends BaseService<OfferModel, OfferDto, Long> {

    private final OfferRepository repository;

    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
        this.repository = offerRepository;
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
