package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.Offer;
import ir.maktab.homeserviceprovider.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends BaseService<Offer, Long> {

    private final OfferRepository repository;

    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
        this.repository = offerRepository;
    }
}
