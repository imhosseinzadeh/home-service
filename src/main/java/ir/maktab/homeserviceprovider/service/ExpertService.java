package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.Expert;
import ir.maktab.homeserviceprovider.model.Service;
import ir.maktab.homeserviceprovider.repository.ExpertRepository;
import ir.maktab.homeserviceprovider.repository.ExpertServiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ExpertService extends UserService<Expert> {

    private final ExpertRepository repository;
    private final ExpertServiceRepository expertServiceRepository;

    public ExpertService(ExpertRepository expertRepository, ExpertServiceRepository expertServiceRepository) {
        super(expertRepository);
        this.repository = expertRepository;
        this.expertServiceRepository = expertServiceRepository;
    }

    Page<Expert> findExpertByService(Service service, Pageable pageable) {
        Page<ir.maktab.homeserviceprovider.model.ExpertService> allByService = expertServiceRepository.findAllByService(service, pageable);
        return allByService.map(ir.maktab.homeserviceprovider.model.ExpertService::getExpert);
    }
}
