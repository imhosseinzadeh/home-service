package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.domain.service.service.ServiceService;
import ir.maktab.homeserviceprovider.domain.service.service.SubServiceService;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.mapper.user.AdminMapper;
import ir.maktab.homeserviceprovider.repository.user.AdminRepository;
import ir.maktab.homeserviceprovider.specification.AdminSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdminService extends UserService<AdminModel, AdminDto> {

    private final AdminRepository repository;
    private final ServiceService serviceService;
    private final SubServiceService subServiceService;
    private final AdminMapper mapper;

    public AdminService(AdminRepository adminRepository, ServiceService serviceService, SubServiceService subServiceService, AdminMapper mapper) {
        super(adminRepository);
        this.repository = adminRepository;
        this.serviceService = serviceService;
        this.subServiceService = subServiceService;
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

    @Transactional
    public Optional<ServiceDto> addService(ServiceDto serviceDto) {
        return this.serviceService.save(serviceDto);
    }

    @Transactional
    public Optional<SubServiceDto> addSubService(SubServiceDto subServiceDto) {
        return this.subServiceService.save(subServiceDto);
    }

    @Override
    public Page<AdminDto> findAll(UserSearchParam searchParam, Pageable pageable) {
        return repository.findAll(AdminSpecifications.withFirstname(searchParam.getFirstname())
                                .and(AdminSpecifications.withLastname(searchParam.getLastname()))
                                .and(AdminSpecifications.withStatus(searchParam.getStatus()))
                        , pageable)
                .map(this::mapToDto);
    }

}
