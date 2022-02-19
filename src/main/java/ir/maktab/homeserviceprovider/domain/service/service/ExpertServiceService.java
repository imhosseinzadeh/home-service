package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.ExpertServiceDto;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceService extends BaseService<ExpertServiceModel, ExpertServiceDto, ExpertServiceModelId> {

    private final ExpertServiceRepository repository;

    public ExpertServiceService(ExpertServiceRepository expertServiceRepository) {
        super(expertServiceRepository);
        this.repository = expertServiceRepository;
    }

    @Override
    protected Class<ExpertServiceModel> getModelClass() {
        return ExpertServiceModel.class;
    }

    @Override
    protected Class<ExpertServiceDto> getDtoClass() {
        return ExpertServiceDto.class;
    }

}
