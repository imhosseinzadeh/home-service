package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import ir.maktab.homeserviceprovider.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceService extends BaseService<ServiceModel, ServiceDto, Long> {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository serviceRepository) {
        super(serviceRepository);
        this.repository = serviceRepository;
    }

    @Override
    protected ServiceDto mapToDto(ServiceModel model) {
        return null;
    }

    @Override
    protected ServiceModel mapToModel(ServiceDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(ServiceDto dto, ServiceModel model) {

    }
}
