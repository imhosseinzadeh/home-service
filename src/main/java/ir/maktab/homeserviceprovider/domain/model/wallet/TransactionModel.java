package ir.maktab.homeserviceprovider.domain.model.wallet;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "Transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "TransactionModel-wallet cannot be null")
    private WalletModel wallet;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "TransactionModel-type cannot be null")
    private TransactionType type;

    @NotNull(message = "TransactionModel-amount cannot be null")
    private BigDecimal amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", wallet=" + wallet +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
