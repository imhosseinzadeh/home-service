package ir.maktab.homeserviceprovider.dto.order;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ReviewDto extends BaseDto<Long> {

    @NotNull(message = "ReviewDto-customer cannot be null")
    private CustomerModel customer;

    @NotNull(message = "ReviewDto-expert cannot be null")
    private ExpertModel expert;

    @NotNull(message = "ReviewDto-score cannot be null")
    @PositiveOrZero(message = "ReviewDto-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    private String comment;
}
