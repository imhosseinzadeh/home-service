package ir.maktab.homeserviceprovider.controller.user;

import ir.maktab.homeserviceprovider.dto.user.UserDto;
import ir.maktab.homeserviceprovider.dto.user.param.ChangePasswordParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
public interface IUserController<D extends UserDto> {

    @PostMapping("/signup")
    ResponseEntity<D> signup(@RequestBody @Valid D registerDto);

    @GetMapping("/profile/{id}")
    ResponseEntity<D> getProfile(@PathVariable Long id);

    @PutMapping("/profile/{id}")
    ResponseEntity<D> updateProfile(@PathVariable Long id, @RequestBody @Valid D dto);

    @PutMapping("/change-password/{id}")
    ResponseEntity<String> changePassword(@PathVariable Long id, @RequestBody @Valid ChangePasswordParam param);

    @DeleteMapping("/delete-account/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable Long id);

}
