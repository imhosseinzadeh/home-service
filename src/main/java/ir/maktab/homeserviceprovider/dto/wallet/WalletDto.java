package ir.maktab.homeserviceprovider.dto.wallet;

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
public class WalletDto extends BaseDto<Long> {

    @NotNull(message = "WalletDto-userId cannot be null")
    private Long userId;

    @NotNull(message = "WalletDto-balance cannot be null")
    private BigDecimal balance;
}
