package ir.maktab.homeserviceprovider.controller.user;

import ir.maktab.homeserviceprovider.domain.service.user.AdminService;
import ir.maktab.homeserviceprovider.domain.service.user.CustomerService;
import ir.maktab.homeserviceprovider.domain.service.user.ExpertService;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import ir.maktab.homeserviceprovider.dto.user.ChangePasswordParam;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.exception.WrongDataInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController implements IUserController<AdminDto> {

    private final AdminService service;
    private final CustomerService customerService;
    private final ExpertService expertService;

    @GetMapping("/customer-list/{page}")
    public ResponseEntity<Page<CustomerDto>> getCustomerList(@PathVariable int page) {
        return ResponseEntity
                .ok(this.customerService.findAllByPage(Pageable
                        .ofSize(10)
                        .withPage(page - 1)));
    }

    @GetMapping("/expert-list/{page}")
    public ResponseEntity<Page<ExpertDto>> getExpertsList(@PathVariable int page) {
        return ResponseEntity
                .ok(this.expertService.findAllByPage(Pageable
                        .ofSize(10)
                        .withPage(page - 1)));
    }

    @Override
    public ResponseEntity<AdminDto> signup(AdminDto registerDto) {
        Optional<AdminDto> optSaved = this.service.save(registerDto);
        return optSaved
                .map(savedDto -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedDto))
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<AdminDto> getProfile(Long id) {
        Optional<AdminDto> optLoaded = this.service.load(id);
        return optLoaded
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<AdminDto> updateProfile(Long id, AdminDto dto) {
        dto.setId(id);
        Optional<AdminDto> optUpdated = this.service.update(dto);
        return optUpdated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<String> changePassword(Long id, ChangePasswordParam param) {
        try {
            this.service.updatePasswordById(id, param);
            return ResponseEntity.ok("Admin password changed successfully");
        } catch (WrongDataInputException | DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteAccount(Long id) {
        try {
            this.service.deleteById(id);
            return ResponseEntity.ok("Admin account has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Admin with id: " + id + " does not exist");
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
