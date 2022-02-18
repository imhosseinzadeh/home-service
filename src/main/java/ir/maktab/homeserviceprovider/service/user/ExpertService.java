package ir.maktab.homeserviceprovider.service.user;

import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import ir.maktab.homeserviceprovider.repository.user.ExpertRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpertService extends UserService<ExpertModel, ExpertDto> {

    private final ExpertRepository repository;
    private final ExpertServiceRepository expertServiceRepository;

    public ExpertService(ExpertRepository expertRepository, ExpertServiceRepository expertServiceRepository) {
        super(expertRepository);
        this.repository = expertRepository;
        this.expertServiceRepository = expertServiceRepository;
    }

    @Override
    protected Class<ExpertModel> getModelClass() {
        return ExpertModel.class;
    }

    @Override
    protected Class<ExpertDto> getDtoClass() {
        return ExpertDto.class;
    }

    @Transactional(readOnly = true)
    public Page<ExpertModel> findExpertsByService(ServiceModel service, Pageable pageable) {
        Page<ExpertServiceModel> allByService = expertServiceRepository.findAllByService(service, pageable);
        return allByService.map(ExpertServiceModel::getExpert);
    }

}
