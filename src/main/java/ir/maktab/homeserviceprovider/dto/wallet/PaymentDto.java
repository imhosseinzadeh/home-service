package ir.maktab.homeserviceprovider.dto.wallet;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.model.wallet.WalletModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PaymentDto extends BaseDto<Long> {

    @NotNull(message = "PaymentDto-srcWallet cannot be null")
    private WalletModel srcWallet;

    @NotNull(message = "PaymentDto-trgWallet cannot be null")
    private WalletModel trgWallet;

    @NotNull(message = "PaymentDto-amount cannot be null")
    private BigDecimal amount;
}
