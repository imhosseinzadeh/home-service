package ir.maktab.homeserviceprovider.controller.user;

import ir.maktab.homeserviceprovider.dto.user.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Validated
public interface IUserController<D extends UserDto> {

    @PostMapping("/signup")
    ResponseEntity<D> signUp(@RequestBody @Valid D registerDto);

    @GetMapping("/profile/{id}")
    ResponseEntity<D> getProfile(@PathVariable Long id);

    @PutMapping("/profile/{id}")
    ResponseEntity<D> updateProfile(@PathVariable Long id, @RequestBody @Valid D dto);

    @PutMapping("/change-password/{id}")
    ResponseEntity<String> changePassword(@PathVariable Long id,
                                          @RequestParam
                                          @NotBlank(message = "UserModel-password cannot be null")
                                          @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for User-password")
                                                  String newPassword);

    @DeleteMapping("/delete-account/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable Long id);

}
