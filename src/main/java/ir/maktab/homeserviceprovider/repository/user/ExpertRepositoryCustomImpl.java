package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModel;
import ir.maktab.homeserviceprovider.domain.model.order.OrderModel_;
import ir.maktab.homeserviceprovider.domain.model.service.*;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ExpertRepositoryCustomImpl implements ExpertRepositoryCustom {

    @PersistenceUnit
    private final EntityManagerFactory managerFactory;
    private final EntityManager entityManager;

    @Autowired
    public ExpertRepositoryCustomImpl(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
        this.entityManager = managerFactory.createEntityManager();
    }

    @Override
    public List<OrderModel> getRelatedOrder(ExpertModel expertModel) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderModel> query = builder.createQuery(OrderModel.class);

        Root<OrderModel> root = query.from(OrderModel.class);

        Join<OrderModel, SubServiceModel> orderJoinSubService = root.join(OrderModel_.subService, JoinType.INNER);
        Join<SubServiceModel, ServiceModel> subServiceJoinService = orderJoinSubService.join(SubServiceModel_.service, JoinType.INNER);
        Join<ServiceModel, ExpertServiceModel> serviceJoinExpertService = subServiceJoinService.join(ServiceModel_.expertServices, JoinType.INNER);
        Join<ExpertServiceModel, ExpertModel> ExpertServiceJoinExpert = serviceJoinExpertService.join(ExpertServiceModel_.expert, JoinType.INNER);

        query.select(root);
        query.where(builder.equal(ExpertServiceJoinExpert.get(ExpertModel_.id), expertModel.getId()));

        TypedQuery<OrderModel> result = entityManager.createQuery(query);
        return result.getResultList();
    }
}
