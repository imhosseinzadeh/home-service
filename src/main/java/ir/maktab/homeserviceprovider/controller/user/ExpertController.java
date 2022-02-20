package ir.maktab.homeserviceprovider.controller.user;

import ir.maktab.homeserviceprovider.domain.service.user.ExpertService;
import ir.maktab.homeserviceprovider.dto.user.ChangePasswordParam;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.exception.WrongDataInputException;
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
@RequestMapping("/experts")
@RequiredArgsConstructor
public class ExpertController implements IUserController<ExpertDto> {

    private final ExpertService service;

    @Override
    public ResponseEntity<ExpertDto> signup(ExpertDto registerDto) {
        Optional<ExpertDto> optSaved = this.service.save(registerDto);
        return optSaved
                .map(savedDto -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(savedDto))
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<ExpertDto> getProfile(Long id) {
        Optional<ExpertDto> optLoaded = this.service.load(id);
        return optLoaded
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<ExpertDto> updateProfile(Long id, ExpertDto dto) {
        dto.setId(id);
        Optional<ExpertDto> optUpdated = this.service.update(dto);
        return optUpdated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<String> changePassword(Long id, ChangePasswordParam param) {
        try {
            service.updatePasswordById(id, param);
            return ResponseEntity.ok("Expert password changed successfully");
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
            return ResponseEntity.ok("Expert account has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Expert with id: " + id + " does not exist");
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
