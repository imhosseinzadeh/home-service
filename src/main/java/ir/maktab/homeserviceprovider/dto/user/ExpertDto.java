package ir.maktab.homeserviceprovider.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.PositiveOrZero;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ExpertDto extends UserDto {
    private byte[] image;

    @PositiveOrZero(message = "ExpertDto-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;
}
