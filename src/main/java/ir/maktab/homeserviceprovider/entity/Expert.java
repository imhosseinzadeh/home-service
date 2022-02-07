package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Expert extends User {
    @Builder(builderMethodName = "expertBuilder")
    public Expert(String firstname, String lastname, String email, String password, UserStatus status) {
        super(firstname, lastname, email, password, status);
    }
}