package ir.maktab.homeservice.dto.user.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordParam {
    @NotBlank(message = "ChangePasswordParam-oldPassword cannot be blank")
    private String oldPassword;
    @NotBlank(message = "ChangePasswordParam-newPassword cannot be blank")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for ChangePasswordParam-newPassword")
    private String newPassword;

}
