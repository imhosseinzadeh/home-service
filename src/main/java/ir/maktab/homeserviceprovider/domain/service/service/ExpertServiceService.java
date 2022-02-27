package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.ExpertServiceDto;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceService extends BaseService<ExpertServiceModel, ExpertServiceDto, ExpertServiceModelId> {

    private final ExpertServiceRepository repository;

    public ExpertServiceService(ExpertServiceRepository expertServiceRepository) {
        super(expertServiceRepository);
        this.repository = expertServiceRepository;
    }

    public Page<ExpertServiceModel> findAllByService(ServiceModel service, Pageable pageable) {
        return repository.findAllByService(service, pageable);
    }

    public Page<ExpertServiceModel> findAllByExpert(ExpertModel expert, Pageable pageable) {
        return repository.findAllByExpert(expert, pageable);
    }

    @Override
    protected ExpertServiceDto mapToDto(ExpertServiceModel model) {
        return null;
    }

    @Override
    protected ExpertServiceModel mapToModel(ExpertServiceDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(ExpertServiceDto dto, ExpertServiceModel model) {

    }
}
