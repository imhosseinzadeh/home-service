package ir.maktab.homeservice.repository.user;

import ir.maktab.homeservice.domain.model.order.OrderModel;
import ir.maktab.homeservice.domain.model.order.OrderModel_;
import ir.maktab.homeservice.domain.model.service.*;
import ir.maktab.homeservice.domain.model.user.ExpertModel;
import ir.maktab.homeservice.domain.model.user.UserModel_;
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
    public List<OrderModel> getRelatedOrder(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderModel> query = builder.createQuery(OrderModel.class);

        Root<OrderModel> root = query.from(OrderModel.class);

        Join<OrderModel, SubServiceModel> orderJoinSubService = root.join(OrderModel_.subService, JoinType.INNER);
        Join<SubServiceModel, ServiceModel> subServiceJoinService = orderJoinSubService.join(SubServiceModel_.service, JoinType.INNER);
        Join<ServiceModel, ExpertServiceModel> serviceJoinExpertService = subServiceJoinService.join(ServiceModel_.expertServices, JoinType.INNER);
        Join<ExpertServiceModel, ExpertModel> expertServiceJoinExpert = serviceJoinExpertService.join(ExpertServiceModel_.expert, JoinType.INNER);

        query.select(root);
        query.where(builder.equal(expertServiceJoinExpert.get(UserModel_.id), id));

        TypedQuery<OrderModel> result = entityManager.createQuery(query);
        return result.getResultList();
    }
}
