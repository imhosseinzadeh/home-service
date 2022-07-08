package ir.maktab.homeservice.domain.service.service;

import ir.maktab.homeservice.domain.model.service.ExpertServiceModel;
import ir.maktab.homeservice.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeservice.domain.model.service.ServiceModel;
import ir.maktab.homeservice.domain.model.user.ExpertModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.service.ExpertServiceDto;
import ir.maktab.homeservice.mapper.user.ExpertServiceMapper;
import ir.maktab.homeservice.repository.service.ExpertServiceRepository;
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

    @Transactional(readOnly = true)
    public Page<ExpertServiceModel> findAllByService(ServiceModel service, Pageable pageable) {
        return repository.findAllByService(service, pageable);
    }

    @Transactional(readOnly = true)
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
