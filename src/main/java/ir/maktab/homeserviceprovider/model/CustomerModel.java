package ir.maktab.homeserviceprovider.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class CustomerModel extends UserModel {

    @OneToMany(mappedBy = "customer")
    private Set<OrderModel> orders = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<ReviewModel> reviews = new HashSet<>();

    @Builder(builderMethodName = "customerBuilder")
    public CustomerModel(String firstname, String lastname, String email, String password, UserModelStatus status, String customerFiled) {
        super(firstname, lastname, email, password, status);
    }
}
