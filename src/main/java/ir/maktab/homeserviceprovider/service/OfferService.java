package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.OfferModel;
import ir.maktab.homeserviceprovider.repository.OfferRepository;

import org.springframework.stereotype.Service;

@Service
public class OfferService extends BaseService<OfferModel, Long> {

    private final OfferRepository repository;

    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
        this.repository = offerRepository;
    }
}
