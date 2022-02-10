package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.ServiceModel;
import ir.maktab.homeserviceprovider.repository.ServiceRepository;

import org.springframework.stereotype.Service;

@Service
public class ServiceService extends BaseService<ServiceModel, Long> {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository serviceRepository) {
        super(serviceRepository);
        this.repository = serviceRepository;
    }
}
