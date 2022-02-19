package ir.maktab.homeserviceprovider.controller;

import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.service.user.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController implements IUserController<CustomerDto> {

    private final CustomerService service;

    @Override
    public ResponseEntity<CustomerDto> signUp(CustomerDto registerDto) {
        Optional<CustomerDto> optSaved = service.save(registerDto);
        return optSaved.map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto))
                .orElse(null);
    }

    @Override
    public ResponseEntity<CustomerDto> getProfile(Long id) {
        Optional<CustomerDto> optLoaded = this.service.load(id);
        return optLoaded.map(ResponseEntity::ok)
                .orElse(null);
    }

    @Override
    public ResponseEntity<CustomerDto> updateProfile(Long id, CustomerDto customerDto) {
        customerDto.setId(id);
        Optional<CustomerDto> optUpdated = this.service.update(customerDto);
        return optUpdated.map(ResponseEntity::ok)
                .orElse(null);
    }

    @Override
    public ResponseEntity<String> changePassword(Long id, String newPassword) {
        try {
            service.updatePasswordById(id, newPassword);
            return ResponseEntity.ok("Customer password changed successfully");
        } catch (DataNotExistsException e) {
            return ResponseEntity.ok("Customer with id:" + id + " does not exist");
        }
    }

    @Override
    public ResponseEntity<String> deleteAccount(Long id) {
        try {
            this.service.deleteById(id);
            return ResponseEntity.ok("Customer account has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity.ok("Customer with id:" + id + " does not exist");
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

