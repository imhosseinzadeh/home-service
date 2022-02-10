package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.Service;
import ir.maktab.homeserviceprovider.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService extends BaseService<Service, Long> {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository serviceRepository) {
        super(serviceRepository);
        this.repository = serviceRepository;
    }
}
