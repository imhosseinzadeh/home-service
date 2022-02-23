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
    protected AdminDto mapToDto(AdminModel model) {
        return null;
    }

    @Override
    protected AdminModel mapToModel(AdminDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(AdminDto dto, AdminModel model) {

    }
}
