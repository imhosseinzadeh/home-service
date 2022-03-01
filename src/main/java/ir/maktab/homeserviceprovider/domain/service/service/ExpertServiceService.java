package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.ExpertServiceDto;
import ir.maktab.homeserviceprovider.mapper.user.ExpertServiceMapper;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpertServiceService extends BaseService<ExpertServiceModel, ExpertServiceDto, ExpertServiceModelId> {

    private final ExpertServiceRepository repository;
    private final ExpertServiceMapper expertServiceMapper;

    public ExpertServiceService(ExpertServiceRepository repository, ExpertServiceMapper expertServiceMapper) {
        super(repository, expertServiceMapper);
        this.repository = repository;
        this.expertServiceMapper = expertServiceMapper;
    }

    public Page<ExpertServiceModel> findAllByService(ServiceModel service, Pageable pageable) {
        return repository.findAllByService(service, pageable);
    }

    public Page<ExpertServiceModel> findAllByExpert(ExpertModel expert, Pageable pageable) {
        return repository.findAllByExpert(expert, pageable);
    }

    @Transactional(readOnly = true)
    public Page<ServiceModel> findServicesByExpert(ExpertModel expert, Pageable pageable) {
        Page<ExpertServiceModel> allByExpert = findAllByExpert(expert, pageable);
        return allByExpert.map(ExpertServiceModel::getService);
    }

    @Transactional(readOnly = true)
    public Page<ExpertModel> findExpertsByService(ServiceModel service, Pageable pageable) {
        Page<ExpertServiceModel> allByService = findAllByService(service, pageable);
        return allByService.map(ExpertServiceModel::getExpert);
    }

}
