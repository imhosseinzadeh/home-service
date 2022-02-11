package ir.maktab.homeserviceprovider.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "wallet")
@RequiredArgsConstructor
@Getter
@Setter
public class WalletModel implements BaseModel<Long> {

    @Id
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToOne(optional = false)
    @MapsId
    @NotNull(message = "Wallet-user cannot be null")
    private UserModel user;

    private BigDecimal balance;

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    @Override
    public String toString() {
        return "WalletModel{" +
                "id=" + id +
                ", user email=" + user.getEmail() +
                ", balance=" + balance +
                '}';
    }
}