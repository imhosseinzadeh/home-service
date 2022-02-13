package ir.maktab.homeserviceprovider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private WalletModel wallet;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

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
