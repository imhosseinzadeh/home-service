package ir.maktab.homeserviceprovider.service.service;

import ir.maktab.homeserviceprovider.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.repository.service.ServiceRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ServiceService extends BaseService<ServiceModel, Long> {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository serviceRepository) {
        super(serviceRepository);
        this.repository = serviceRepository;
    }
}
