package ir.maktab.homeserviceprovider.domain.model.wallet;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "PaymentModel-srcWallet cannot be null")
    private WalletModel srcWallet;

    @ManyToOne
    @NotNull(message = "PaymentModel-trgWallet cannot be null")
    private WalletModel trgWallet;

    @NotNull(message = "PaymentModel-amount cannot be null")
    private BigDecimal amount;

    @Override
    public void onPersist() {
        super.onPersist();
        transfer();
    }

    private void transfer() {
        // TODO: 2/13/2022 complete transfer method
        srcWallet.setBalance(srcWallet.getBalance().subtract(amount));
        trgWallet.setBalance(trgWallet.getBalance().add(amount));
    }

}
