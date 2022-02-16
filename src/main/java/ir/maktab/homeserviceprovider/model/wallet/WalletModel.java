package ir.maktab.homeserviceprovider.model.wallet;

import ir.maktab.homeserviceprovider.model.BaseModel;
import ir.maktab.homeserviceprovider.model.user.UserModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "wallet")
@RequiredArgsConstructor
@Getter
@Setter
public class WalletModel extends BaseModel<Long> {

    @Id
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToOne(optional = false)
    @MapsId
    @NotNull(message = "Wallet-user cannot be null")
    private UserModel user;

    @OneToMany(mappedBy = "wallet")
    private Set<TransactionModel> transactions;

    private BigDecimal balance;

    @Override
    public String toString() {
        return "WalletModel{" +
                "id=" + id +
                ", user email=" + user.getEmail() +
                ", balance=" + balance +
                '}';
    }
}
