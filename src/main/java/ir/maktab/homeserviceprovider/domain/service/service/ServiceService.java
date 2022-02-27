package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import ir.maktab.homeserviceprovider.mapper.service.ServiceMapper;
import ir.maktab.homeserviceprovider.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceService extends BaseService<ServiceModel, ServiceDto, Long> {

    private final ServiceRepository repository;
    private final ServiceMapper mapper;

    public ServiceService(ServiceRepository serviceRepository, ServiceMapper mapper) {
        super(serviceRepository);
        this.repository = serviceRepository;
        this.mapper = mapper;
    }

    @Override
    protected ServiceDto mapToDto(ServiceModel model) {
        return mapper.mapToDto(model);
    }

    @Override
    protected ServiceModel mapToModel(ServiceDto dto) {
        return mapper.mapToModel(dto);
    }

    @Override
    protected void updateModelByDto(ServiceDto dto, ServiceModel model) {
        mapper.updateModelByDto(model, dto);
    }
}
