package ir.maktab.homeserviceprovider.specification;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.domain.model.user.UserModelStatus;
import ir.maktab.homeserviceprovider.domain.model.user.UserModel_;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public final class AdminSpecifications {

    public static Specification<AdminModel> withFirstname(String firstname) {
        if (firstname == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserModel_.firstname), firstname);
    }

    public static Specification<AdminModel> withLastname(String lastname) {
        if (lastname == null) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get(UserModel_.lastname), lastname);
    }

    public static Specification<AdminModel> withStatus(UserModelStatus status) {
        if (status == null) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get(UserModel_.status), status);
    }
}
