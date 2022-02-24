package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import ir.maktab.homeserviceprovider.repository.user.ExpertRepository;
import ir.maktab.homeserviceprovider.repository.user.ExpertSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpertService extends UserService<ExpertModel, ExpertDto> {

    private final ExpertRepository repository;
    private final ExpertServiceRepository expertServiceRepository;
    private final ExpertSpecifications specifications;

    public ExpertService(ExpertRepository expertRepository, ExpertServiceRepository expertServiceRepository, ExpertSpecifications specifications) {
        super(expertRepository, specifications);
        this.repository = expertRepository;
        this.expertServiceRepository = expertServiceRepository;
        this.specifications = specifications;
    }

    @Transactional(readOnly = true)
    public List<OrderModel> getRelatedOrders(ExpertModel expert, Pageable pageable) {
        Page<ServiceModel> relatedServices = findServicesByExpert(expert, pageable);
        List<SubServiceModel> relatedSubServices = getSubServices(relatedServices);
        return getOrders(relatedSubServices);
    }

    private List<OrderModel> getOrders(List<SubServiceModel> subServiceModelList) {
        List<OrderModel> orders = new ArrayList<>();

        for (SubServiceModel s : subServiceModelList) {
            orders.addAll(s.getOrders());
        }

        return orders;
    }

    private List<SubServiceModel> getSubServices(Page<ServiceModel> services) {
        List<SubServiceModel> subServiceList = new ArrayList<>();

        for (ServiceModel s : services) {
            subServiceList.addAll(s.getSubServices());
        }

        return subServiceList;
    }

    @Transactional(readOnly = true)
    public Page<ServiceModel> findServicesByExpert(ExpertModel expert, Pageable pageable) {
        Page<ExpertServiceModel> allByExpert = expertServiceRepository.findAllByExpert(expert, pageable);
        return allByExpert.map(ExpertServiceModel::getService);
    }

    @Transactional(readOnly = true)
    public Page<ExpertModel> findExpertsByService(ServiceModel service, Pageable pageable) {
        Page<ExpertServiceModel> allByService = expertServiceRepository.findAllByService(service, pageable);
        return allByService.map(ExpertServiceModel::getExpert);
    }

    @Override
    protected ExpertDto mapToDto(ExpertModel model) {
        return null;
    }

    @Override
    protected ExpertModel mapToModel(ExpertDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(ExpertDto dto, ExpertModel model) {

    }

    @Override
    public Page<ExpertModel> findAll(Pageable pageable) {
        return repository.findAll(Specification.where(this.specifications
                .withFirstname("test")
                .and(specifications.withLastname("test"))
                .and(specifications.withWalletBalance(new BigDecimal(1L)))
                .and(specifications.withWalletBalanceGt(new BigDecimal(0)))
                .and(specifications.withWalletBalanceLe(new BigDecimal(10L)))), pageable);
    }
}
