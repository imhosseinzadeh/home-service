package ir.maktab.homeserviceprovider.service.order;

import ir.maktab.homeserviceprovider.dto.order.OfferDto;
import ir.maktab.homeserviceprovider.model.order.OfferModel;
import ir.maktab.homeserviceprovider.repository.order.OfferRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends BaseService<OfferModel, OfferDto, Long> {

    private final OfferRepository repository;

    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
        this.repository = offerRepository;
    }

    @Override
    protected Class<OfferModel> getModelClass() {
        return OfferModel.class;
    }

}
