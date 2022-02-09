package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor
public class Manager extends User implements Serializable {
    @Builder(builderMethodName = "managerBuilder")
    public Manager(String firstname, String lastname, String email, String password, UserStatus status) {
        super(firstname, lastname, email, password, status);
    }
}
