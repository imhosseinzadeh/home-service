package ir.maktab.homeserviceprovider.dto.order;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.model.order.OrderModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.ManyToOne;
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

    @NotNull(message = "OfferDto-expert cannot be null")
    private ExpertModel expert;

    @ManyToOne
    @NotNull(message = "OfferDto-order cannot be null")
    private OrderModel order;

    @NotNull(message = "OfferDto-proposalPrice cannot be null")
    private BigDecimal proposalPrice;

    @NotNull(message = "OfferDto-startTime cannot be null")
    private LocalTime startTime;

    @NotNull(message = "OfferDto-period cannot be null")
    private Period period;
}
