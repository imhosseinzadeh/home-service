package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.Manager;
import ir.maktab.homeserviceprovider.repository.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends UserService<Manager> {

    private final ManagerRepository repository;

    public ManagerService(ManagerRepository managerRepository) {
        super(managerRepository);
        this.repository = managerRepository;
    }
}
