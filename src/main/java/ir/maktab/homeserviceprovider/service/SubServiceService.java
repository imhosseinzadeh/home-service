package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.SubServiceModel;
import ir.maktab.homeserviceprovider.repository.SubServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class SubServiceService extends BaseService<SubServiceModel, Long> {

    private final SubServiceRepository repository;

    public SubServiceService(SubServiceRepository subServiceRepository) {
        super(subServiceRepository);
        this.repository = subServiceRepository;
    }
}
