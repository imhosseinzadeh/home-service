package ir.maktab.homeservice.domain.service.service;

import ir.maktab.homeservice.domain.model.service.ServiceModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.service.ServiceDto;
import ir.maktab.homeservice.mapper.service.ServiceMapper;
import ir.maktab.homeservice.repository.service.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceService extends BaseService<ServiceModel, ServiceDto, Long> {

    private final ServiceRepository repository;
    private final ServiceMapper serviceMapper;

    public ServiceService(ServiceRepository repository, ServiceMapper serviceMapper) {
        super(repository, serviceMapper);
        this.repository = repository;
        this.serviceMapper = serviceMapper;
    }
}
