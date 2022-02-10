package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Review> reviews = new HashSet<>();

    @Builder(builderMethodName = "customerBuilder")
    public Customer(String firstname, String lastname, String email, String password, UserStatus status, String customerFiled) {
        super(firstname, lastname, email, password, status);
    }
}
