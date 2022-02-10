package ir.maktab.homeserviceprovider.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Manager extends User {
    @Builder(builderMethodName = "managerBuilder")
    public Manager(String firstname, String lastname, String email, String password, UserStatus status) {
        super(firstname, lastname, email, password, status);
    }
}
