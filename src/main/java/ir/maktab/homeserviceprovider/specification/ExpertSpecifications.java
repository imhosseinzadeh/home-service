package ir.maktab.homeserviceprovider.specification;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel_;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel_;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel_;
import ir.maktab.homeserviceprovider.domain.model.user.UserModelStatus;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

@UtilityClass
public final class ExpertSpecifications {

    public static Specification<ExpertModel> withFirstname(String firstname) {
        if (firstname == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(ExpertModel_.firstname), firstname);
    }

    public static Specification<ExpertModel> withLastname(String lastname) {
        if (lastname == null) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get(ExpertModel_.lastname), lastname);
    }

    public static Specification<ExpertModel> withStatus(UserModelStatus status) {
        if (status == null) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get(ExpertModel_.status), status);
    }

    public static Specification<ExpertModel> withServiceId(Long serviceId) {
        if (serviceId == null) {
            return null;
        }
        return (root, query, builder) -> {
            Join<ExpertModel, ExpertServiceModel> expertJoinExpertService = root.join(ExpertModel_.expertServices, JoinType.INNER);
            Join<ExpertServiceModel, ServiceModel> expertServiceJoinService = expertJoinExpertService.join(ExpertServiceModel_.service, JoinType.INNER);

            return builder.equal(expertServiceJoinService.get(ServiceModel_.id), serviceId);
        };
    }

}
