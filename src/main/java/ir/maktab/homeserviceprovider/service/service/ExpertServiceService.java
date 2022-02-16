package ir.maktab.homeserviceprovider.service.service;

import ir.maktab.homeserviceprovider.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceService extends BaseService<ExpertServiceModel, ExpertServiceModelId> {

    private final ExpertServiceRepository repository;

    public ExpertServiceService(ExpertServiceRepository expertServiceRepository) {
        super(expertServiceRepository);
        this.repository = expertServiceRepository;
    }
}
