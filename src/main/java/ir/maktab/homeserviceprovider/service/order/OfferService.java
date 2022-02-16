package ir.maktab.homeserviceprovider.service.order;

import ir.maktab.homeserviceprovider.model.order.OfferModel;
import ir.maktab.homeserviceprovider.repository.order.OfferRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends BaseService<OfferModel, Long> {

    private final OfferRepository repository;

    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
        this.repository = offerRepository;
    }
}
