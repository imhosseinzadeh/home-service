package ir.maktab.homeservice.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdminDto extends UserDto {
    public AdminDto(@Email(message = "UserDto-email not valid")
                    @NotBlank(message = "UserDto-email cannot be blank")
                            String email,
                    @NotBlank(message = "UserDto-password cannot be null")
                    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for UserDto-password")
                            String password) {
        super(email, password);
    }
}
