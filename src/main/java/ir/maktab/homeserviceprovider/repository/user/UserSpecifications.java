package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.domain.model.user.UserModel;
import ir.maktab.homeserviceprovider.domain.model.user.UserModelStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserSpecifications<U extends UserModel> {

    public Specification<U> withFirstname(String firstname) {
        if (firstname == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstname"), firstname);
    }

    public Specification<U> withLastname(String lastname) {
        if (lastname == null) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get("lastname"), lastname);
    }

    public Specification<U> withStatus(UserModelStatus status) {
        if (status == null) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get("lastname"), status);
    }

    public Specification<U> withWalletBalance(BigDecimal balance) {
        if (balance == null) {
            return null;
        }
        return (root, query, builder) -> builder.gt(root.join("wallet").get("balance"), balance);
    }

    public Specification<U> withWalletBalanceGt(BigDecimal balance) {
        if (balance == null) {
            return null;
        }
        return (root, query, builder) -> builder.gt(root.join("wallet").get("balance"), balance);
    }

    public Specification<U> withWalletBalanceLe(BigDecimal balance) {
        if (balance == null) {
            return null;
        }
        return (root, query, builder) -> builder.le(root.join("wallet").get("balance"), balance);
    }

}
