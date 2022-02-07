package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Customer extends User {
    @Builder(builderMethodName = "customerBuilder")
    public Customer(String firstname, String lastname, String email, String password, UserStatus status, String customerFiled) {
        super(firstname, lastname, email, password, status);
    }
}
