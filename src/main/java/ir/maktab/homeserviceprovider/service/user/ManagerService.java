package ir.maktab.homeserviceprovider.service.user;

import ir.maktab.homeserviceprovider.dto.user.ManagerDto;
import ir.maktab.homeserviceprovider.model.user.ManagerModel;
import ir.maktab.homeserviceprovider.repository.user.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends UserService<ManagerModel, ManagerDto> {

    private final ManagerRepository repository;

    public ManagerService(ManagerRepository managerRepository) {
        super(managerRepository);
        this.repository = managerRepository;
    }

    @Override
    protected Class<ManagerModel> getModelClass() {
        return ManagerModel.class;
    }

    @Override
    protected Class<ManagerDto> getDtoClass() {
        return ManagerDto.class;
    }

}
