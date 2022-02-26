package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.mapper.user.AdminMapper;
import ir.maktab.homeserviceprovider.repository.user.AdminRepository;
import ir.maktab.homeserviceprovider.specification.AdminSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends UserService<AdminModel, AdminDto> {

    private final AdminRepository repository;
    private final AdminMapper mapper;

    public AdminService(AdminRepository adminRepository, AdminMapper mapper) {
        super(adminRepository);
        this.repository = adminRepository;
        this.mapper = mapper;
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

    @Override
    public Page<AdminModel> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(AdminSpecifications.withFirstname(searchParam.getFirstname())
                        .and(AdminSpecifications.withLastname(searchParam.getLastname()))
                        .and(AdminSpecifications.withStatus(searchParam.getStatus()))
                , pageable);
    }

}
