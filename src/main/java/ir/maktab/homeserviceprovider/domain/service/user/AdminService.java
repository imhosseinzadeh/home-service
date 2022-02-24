package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.mapper.user.AdminMapper;
import ir.maktab.homeserviceprovider.repository.user.AdminRepository;
import ir.maktab.homeserviceprovider.repository.user.AdminSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends UserService<AdminModel, AdminDto> {

    private final AdminRepository repository;
    private final AdminMapper mapper;
    private final AdminSpecifications specifications;

    public AdminService(AdminRepository adminRepository, AdminMapper mapper, AdminSpecifications specifications) {
        super(adminRepository, specifications);
        this.repository = adminRepository;
        this.mapper = mapper;
        this.specifications = specifications;
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
        return repository.findAll(Specification.where(this.specifications
                .withFirstname(searchParam.getFirstname())
                .and(specifications.withLastname(searchParam.getLastname()))), pageable);
    }

}
