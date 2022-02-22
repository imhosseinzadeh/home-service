package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.repository.service.ExpertServiceRepository;
import ir.maktab.homeserviceprovider.repository.user.ExpertRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpertService extends UserService<ExpertModel, ExpertDto> {

    private final ExpertRepository repository;
    private final ExpertServiceRepository expertServiceRepository;

    public ExpertService(ExpertRepository expertRepository, ExpertServiceRepository expertServiceRepository) {
        super(expertRepository);
        this.repository = expertRepository;
        this.expertServiceRepository = expertServiceRepository;
    }

    @Override
    protected Class<ExpertModel> getModelClass() {
        return ExpertModel.class;
    }

    @Override
    protected Class<ExpertDto> getDtoClass() {
        return ExpertDto.class;
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
}
