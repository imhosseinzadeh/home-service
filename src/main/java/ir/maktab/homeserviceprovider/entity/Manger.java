package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Manger extends User {
    @Builder(builderMethodName = "managerBuilder")
    public Manger(String firstname, String lastname, String email, String password, UserStatus status) {
        super(firstname, lastname, email, password, status);
    }
}
