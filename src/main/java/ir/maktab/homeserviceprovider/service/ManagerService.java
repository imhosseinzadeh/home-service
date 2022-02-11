package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.ManagerModel;
import ir.maktab.homeserviceprovider.repository.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends UserService<ManagerModel> {

    private final ManagerRepository repository;

    public ManagerService(ManagerRepository managerRepository) {
        super(managerRepository);
        this.repository = managerRepository;
    }
}
