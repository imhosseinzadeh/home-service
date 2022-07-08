package ir.maktab.homeservice.dto.wallet;

import ir.maktab.homeservice.domain.model.wallet.WalletModel;
import ir.maktab.homeservice.dto.BaseDto;
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
public class PaymentDto extends BaseDto<Long> {

    @NotNull(message = "PaymentDto-srcWallet cannot be null")
    private WalletModel srcWallet;

    @NotNull(message = "PaymentDto-trgWallet cannot be null")
    private WalletModel trgWallet;

    @NotNull(message = "PaymentDto-amount cannot be null")
    private BigDecimal amount;
}
