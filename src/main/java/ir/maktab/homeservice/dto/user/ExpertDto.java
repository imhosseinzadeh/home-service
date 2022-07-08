package ir.maktab.homeservice.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExpertDto extends UserDto {
    private byte[] image;

    @PositiveOrZero(message = "ExpertDto-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    public ExpertDto(@Email(message = "UserDto-email not valid")
                     @NotBlank(message = "UserDto-email cannot be blank")
                             String email,
                     @NotBlank(message = "UserDto-password cannot be null")
                     @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for UserDto-password")
                             String password,
                     byte[] image,
                     Integer score) {
        super(email, password);
        this.image = image;
        this.score = score;
    }
}
