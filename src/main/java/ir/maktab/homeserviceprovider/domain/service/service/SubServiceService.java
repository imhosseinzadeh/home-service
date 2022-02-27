package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.mapper.service.SubServiceMapper;
import ir.maktab.homeserviceprovider.repository.service.SubServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class SubServiceService extends BaseService<SubServiceModel, SubServiceDto, Long> {

    private final SubServiceRepository repository;
    private final SubServiceMapper mapper;

    public SubServiceService(SubServiceRepository subServiceRepository, SubServiceMapper mapper) {
        super(subServiceRepository);
        this.repository = subServiceRepository;
        this.mapper = mapper;
    }


    @Override
    protected SubServiceDto mapToDto(SubServiceModel model) {
        return mapper.mapToDto(model);
    }

    @Override
    protected SubServiceModel mapToModel(SubServiceDto dto) {
        return mapper.mapToModel(dto);
    }

    @Override
    protected void updateModelByDto(SubServiceDto dto, SubServiceModel model) {
        mapper.updateModelByDto(model, dto);
    }
}
