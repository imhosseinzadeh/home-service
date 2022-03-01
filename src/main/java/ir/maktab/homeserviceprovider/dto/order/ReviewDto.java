package ir.maktab.homeserviceprovider.dto.order;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReviewDto extends BaseDto<Long> {

    @NotNull(message = "ReviewDto-customerId cannot be null")
    private Long customerId;

    @NotNull(message = "ReviewDto-expertId cannot be null")
    private Long expertId;

    @NotNull(message = "ReviewDto-score cannot be null")
    @PositiveOrZero(message = "ReviewDto-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    private String comment;
}
