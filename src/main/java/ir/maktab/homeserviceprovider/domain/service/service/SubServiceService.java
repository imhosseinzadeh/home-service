package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.repository.service.SubServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class SubServiceService extends BaseService<SubServiceModel, SubServiceDto, Long> {

    private final SubServiceRepository repository;

    public SubServiceService(SubServiceRepository subServiceRepository) {
        super(subServiceRepository);
        this.repository = subServiceRepository;
    }


    @Override
    protected SubServiceDto mapToDto(SubServiceModel model) {
        return null;
    }

    @Override
    protected SubServiceModel mapToModel(SubServiceDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(SubServiceDto dto, SubServiceModel model) {

    }
}
