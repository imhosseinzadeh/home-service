package ir.maktab.homeserviceprovider.model.wallet;

import ir.maktab.homeserviceprovider.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private WalletModel srcWallet;

    @ManyToOne
    private WalletModel trgWallet;

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
