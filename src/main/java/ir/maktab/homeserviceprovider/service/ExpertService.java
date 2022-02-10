package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.ExpertModel;
import ir.maktab.homeserviceprovider.model.ExpertServiceModel;
import ir.maktab.homeserviceprovider.model.ServiceModel;
import ir.maktab.homeserviceprovider.repository.ExpertRepository;
import ir.maktab.homeserviceprovider.repository.ExpertServiceRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExpertService extends UserService<ExpertModel> {

    private final ExpertRepository repository;
    private final ExpertServiceRepository expertServiceRepository;

    public ExpertService(ExpertRepository expertRepository, ExpertServiceRepository expertServiceRepository) {
        super(expertRepository);
        this.repository = expertRepository;
        this.expertServiceRepository = expertServiceRepository;
    }

    Page<ExpertModel> findExpertsByService(ServiceModel service, Pageable pageable) {
        Page<ExpertServiceModel> allByService = expertServiceRepository.findAllByService(service, pageable);
        return allByService.map(ExpertServiceModel::getExpert);
    }
}
