package ir.maktab.homeserviceprovider.dto.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.TransactionType;
import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TransactionDto extends BaseDto<Long> {

    @NotNull(message = "TransactionDto-wallet cannot be null")
    private WalletModel wallet;

    @NotNull(message = "TransactionDto-type cannot be null")
    private TransactionType type;

    @NotNull(message = "TransactionDto-amount cannot be null")
    private BigDecimal amount;
}
