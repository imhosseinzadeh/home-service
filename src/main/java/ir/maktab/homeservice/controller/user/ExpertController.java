package ir.maktab.homeservice.controller.user;

import ir.maktab.homeservice.domain.service.order.OfferService;
import ir.maktab.homeservice.domain.service.service.ExpertServiceService;
import ir.maktab.homeservice.domain.service.user.ExpertService;
import ir.maktab.homeservice.dto.order.OfferDto;
import ir.maktab.homeservice.dto.order.OrderDto;
import ir.maktab.homeservice.dto.service.ExpertServiceDto;
import ir.maktab.homeservice.dto.user.ExpertDto;
import ir.maktab.homeservice.dto.user.param.ChangePasswordParam;
import ir.maktab.homeservice.exception.DataNotExistsException;
import ir.maktab.homeservice.exception.WrongDataInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/experts")
@RequiredArgsConstructor
public class ExpertController implements IUserController<ExpertDto> {

    private final ExpertService service;
    private final ExpertServiceService expertServiceService;
    private final OfferService offerService;

    @Override
    public ResponseEntity<ExpertDto> signup(ExpertDto expertDto) {
        ExpertDto saved = this.service.save(expertDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public ResponseEntity<ExpertDto> getProfile(Long expertId) {
        Optional<ExpertDto> optExpertDto = this.service.findById(expertId);
        return optExpertDto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<ExpertDto> updateProfile(Long expertId, ExpertDto expertDto) {
        expertDto.setId(expertId);
        Optional<ExpertDto> optUpdated = this.service.update(expertDto);
        return optUpdated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<String> changePassword(Long expertId, ChangePasswordParam changePasswordParam) {
        try {
            service.updatePasswordById(expertId, changePasswordParam);
            return ResponseEntity.ok("Expert password changed successfully");
        } catch (WrongDataInputException | DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteAccount(Long expertId) {
        try {
            this.service.deleteById(expertId);
            return ResponseEntity.ok("Expert account has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Expert with id: " + expertId + " does not exist");
        }
    }

    @PostMapping("add-service-to-expert")
    public ResponseEntity<ExpertServiceDto> addServiceToExpert(@RequestBody ExpertServiceDto expertServiceDto) {
        return ResponseEntity.ok(this.expertServiceService.save(expertServiceDto));
    }

    @GetMapping("related-orders/{expertId}")
    public ResponseEntity<List<OrderDto>> getRelatedOrders(@PathVariable Long expertId) {
        return ResponseEntity.ok(this.service.getRelatedOrders(expertId));
    }

    @PutMapping("offer-to-order")
    public ResponseEntity<OfferDto> offerToOrder(@RequestBody OfferDto offerDto) {
        OfferDto offered = this.offerService.save(offerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(offered);
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
