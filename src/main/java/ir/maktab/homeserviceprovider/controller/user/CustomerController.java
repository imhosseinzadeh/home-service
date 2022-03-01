package ir.maktab.homeserviceprovider.controller.user;

import ir.maktab.homeserviceprovider.domain.service.user.CustomerService;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.dto.user.param.ChangePasswordParam;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.exception.WrongDataInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController implements IUserController<CustomerDto> {

    private final CustomerService service;

    @Override
    public ResponseEntity<CustomerDto> signup(CustomerDto customerDto) {
        CustomerDto saved = this.service.save(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public ResponseEntity<CustomerDto> getProfile(Long customerId) {
        Optional<CustomerDto> optLoaded = this.service.findById(customerId);
        return optLoaded
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<CustomerDto> updateProfile(Long id, CustomerDto customerDto) {
        customerDto.setId(id);
        Optional<CustomerDto> optUpdated = this.service.update(customerDto);
        return optUpdated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @GetMapping("orders-history/{customerId}")
    public ResponseEntity<Set<OrderDto>> ordersHistory(@PathVariable Long customerId) {
        try {
            return ResponseEntity.ok(this.service.ordersHistory(customerId));
        } catch (DataNotExistsException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ResponseEntity<String> changePassword(Long id, ChangePasswordParam changePasswordParam) {
        try {
            this.service.updatePasswordById(id, changePasswordParam);
            return ResponseEntity.ok("Customer password changed successfully");
        } catch (WrongDataInputException | DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteAccount(Long customerId) {
        try {
            this.service.deleteById(customerId);
            return ResponseEntity.ok("Customer account has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Customer with id: " + customerId + " does not exist");
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

