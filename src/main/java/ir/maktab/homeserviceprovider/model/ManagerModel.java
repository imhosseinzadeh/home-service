package ir.maktab.homeserviceprovider.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "Manager")
@NoArgsConstructor
public class ManagerModel extends UserModel {
    @Builder(builderMethodName = "managerBuilder")
    public ManagerModel(String firstname, String lastname, String email, String password, UserModelStatus status) {
        super(firstname, lastname, email, password, status);
    }
}
