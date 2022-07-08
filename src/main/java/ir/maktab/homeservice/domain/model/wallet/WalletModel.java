package ir.maktab.homeservice.domain.model.wallet;

import ir.maktab.homeservice.domain.model.BaseModel;
import ir.maktab.homeservice.domain.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "\"Wallet\"")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WalletModel extends BaseModel<Long> {

    @Id
    private Long id;

    @OneToOne(optional = false)
    @MapsId
    @NotNull(message = "WalletModel-user cannot be null")
    private UserModel user;

    @OneToMany(mappedBy = "wallet")
    private Set<TransactionModel> transactions;

    @NotNull(message = "WalletModel-balance cannot be null")
    private BigDecimal balance;

    @Override
    public String toString() {
        return "WalletModel{" +
                "id=" + id +
                ", user email=" + user.getEmail() +
                ", balance=" + balance +
                '}';
    }

    @Override
    public void onPersist() {
        super.onPersist();
        balance = new BigDecimal(0);
    }

}
