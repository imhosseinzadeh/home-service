package ir.maktab.homeservice.domain.service.user;

import ir.maktab.homeservice.domain.model.user.AdminModel;
import ir.maktab.homeservice.dto.user.AdminDto;
import ir.maktab.homeservice.dto.user.param.UserSearchParam;
import ir.maktab.homeservice.mapper.user.AdminMapper;
import ir.maktab.homeservice.repository.user.AdminRepository;
import ir.maktab.homeservice.specification.AdminSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService extends UserService<AdminModel, AdminDto> {

    private final AdminRepository repository;
    private final AdminMapper adminMapper;

    public AdminService(AdminRepository repository, AdminMapper adminMapper) {
        super(repository, adminMapper);
        this.repository = repository;
        this.adminMapper = adminMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdminDto> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(AdminSpecifications.withFirstname(searchParam.getFirstname())
                                .and(AdminSpecifications.withLastname(searchParam.getLastname()))
                                .and(AdminSpecifications.withStatus(searchParam.getStatus()))
                        , pageable)
                .map(adminMapper::mapToDto);
    }

}
