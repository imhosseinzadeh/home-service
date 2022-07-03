package ir.maktab.homeserviceprovider.domain.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"Admin\"")
@NoArgsConstructor
@Getter
@Setter
public class AdminModel extends UserModel {

    @Builder(builderMethodName = "adminBuilder")
    public AdminModel(Long id, String firstname, String lastname, String email, String password, UserModelStatus status) {
        super(id, firstname, lastname, email, password, status);
    }

}
