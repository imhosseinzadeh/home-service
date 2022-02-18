package ir.maktab.homeserviceprovider.service.service;

import ir.maktab.homeserviceprovider.dto.service.ExpertServiceDto;
import ir.maktab.homeserviceprovider.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
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
