package ir.maktab.homeserviceprovider.domain.model.user;

import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "Admin")
@NoArgsConstructor
public class AdminModel extends UserModel {
    @Builder(builderMethodName = "adminBuilder")
    public AdminModel(String firstname, String lastname, String email, String password, UserModelStatus status, WalletModel wallet) {
        super(firstname, lastname, email, password, status, wallet);
    }
}
