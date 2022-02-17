package ir.maktab.homeserviceprovider.dto.user;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDto<Long> {

    @Email(message = "UserDto-email not valid")
    @NotBlank(message = "UserDto-email cannot be blank")
    private String email;

    @NotBlank(message = "UserDto-password cannot be null")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for UserDto-password")
    private String password;
}
