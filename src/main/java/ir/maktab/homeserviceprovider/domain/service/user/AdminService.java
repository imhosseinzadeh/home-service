package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import ir.maktab.homeserviceprovider.repository.user.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends UserService<AdminModel, AdminDto> {

    private final AdminRepository repository;

    public AdminService(AdminRepository adminRepository) {
        super(adminRepository);
        this.repository = adminRepository;
    }

    @Override
    protected Class<AdminModel> getModelClass() {
        return AdminModel.class;
    }

    @Override
    protected Class<AdminDto> getDtoClass() {
        return AdminDto.class;
    }

}
