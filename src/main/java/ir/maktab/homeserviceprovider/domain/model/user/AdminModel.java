package ir.maktab.homeserviceprovider.domain.model.user;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "Admin")
@NoArgsConstructor
public class AdminModel extends UserModel {
    @Builder(builderMethodName = "adminBuilder")
    public AdminModel(String firstname, String lastname, String email, String password, UserModelStatus status) {
        super(firstname, lastname, email, password, status);
    }
}
