package ir.maktab.homeservice.dto.order;

import ir.maktab.homeservice.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.Period;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OfferDto extends BaseDto<Long> {

    @NotNull(message = "OfferDto-expertId cannot be null")
    private Long expertId;

    @NotNull(message = "OfferDto-orderId cannot be null")
    private Long orderId;

    @NotNull(message = "OfferDto-proposalPrice cannot be null")
    private BigDecimal proposalPrice;

    @NotNull(message = "OfferDto-startTime cannot be null")
    private LocalTime startTime;

    @NotNull(message = "OfferDto-period cannot be null")
    private Period period;
}
