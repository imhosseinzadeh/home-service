package ir.maktab.homeserviceprovider.service.service;

import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.repository.service.SubServiceRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SubServiceService extends BaseService<SubServiceModel, SubServiceDto, Long> {

    private final SubServiceRepository repository;

    public SubServiceService(SubServiceRepository subServiceRepository) {
        super(subServiceRepository);
        this.repository = subServiceRepository;
    }

    @Override
    protected Class<SubServiceModel> getModelClass() {
        return SubServiceModel.class;
    }

}
