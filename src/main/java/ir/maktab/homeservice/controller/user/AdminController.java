package ir.maktab.homeservice.controller.user;

import ir.maktab.homeservice.domain.service.service.ExpertServiceService;
import ir.maktab.homeservice.domain.service.service.ServiceService;
import ir.maktab.homeservice.domain.service.service.SubServiceService;
import ir.maktab.homeservice.domain.service.user.AdminService;
import ir.maktab.homeservice.domain.service.user.CustomerService;
import ir.maktab.homeservice.domain.service.user.ExpertService;
import ir.maktab.homeservice.dto.service.ExpertServiceDto;
import ir.maktab.homeservice.dto.service.ServiceDto;
import ir.maktab.homeservice.dto.service.SubServiceDto;
import ir.maktab.homeservice.dto.user.AdminDto;
import ir.maktab.homeservice.dto.user.CustomerDto;
import ir.maktab.homeservice.dto.user.ExpertDto;
import ir.maktab.homeservice.dto.user.param.ChangePasswordParam;
import ir.maktab.homeservice.exception.DataNotExistsException;
import ir.maktab.homeservice.exception.WrongDataInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final ServiceService serviceService;
    private final SubServiceService subServiceService;
    private final ExpertServiceService expertServiceService;
    private final CustomerService customerService;
    private final ExpertService expertService;

    @GetMapping("/customers-list/{page}")
    public ResponseEntity<Page<CustomerDto>> getCustomersList(@PathVariable int page) {
        return ResponseEntity
                .ok(this.customerService.findAllByPage(PageRequest.of(page, 10)));
    }

    @GetMapping("/experts-list/{page}")
    public ResponseEntity<Page<ExpertDto>> getExpertsList(@PathVariable int page) {
        return ResponseEntity
                .ok(this.expertService.findAllByPage(PageRequest.of(page, 10)));
    }

    @PostMapping("add-service")
    public ResponseEntity<ServiceDto> addService(ServiceDto serviceDto) {
        ServiceDto savedService = this.serviceService.save(serviceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedService);
    }

    @PostMapping("add-subService")
    public ResponseEntity<SubServiceDto> addSubService(SubServiceDto subServiceDto) {
        SubServiceDto savedSubService = this.subServiceService.save(subServiceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubService);
    }

    @PostMapping("add-service-to-expert")
    public ResponseEntity<ExpertServiceDto> addServiceToExpert(@RequestBody ExpertServiceDto expertServiceDto) {
        return ResponseEntity.ok(this.expertServiceService.save(expertServiceDto));
    }

    @Override
    public ResponseEntity<AdminDto> signup(AdminDto adminDto) {
        AdminDto saved = this.service.save(adminDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public ResponseEntity<AdminDto> getProfile(Long adminId) {
        Optional<AdminDto> optLoaded = this.service.findById(adminId);
        return optLoaded
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<AdminDto> updateProfile(Long adminId, AdminDto adminDto) {
        adminDto.setId(adminId);
        Optional<AdminDto> optUpdated = this.service.update(adminDto);
        return optUpdated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @Override
    public ResponseEntity<String> changePassword(Long adminId, ChangePasswordParam changePasswordParam) {
        try {
            this.service.updatePasswordById(adminId, changePasswordParam);
            return ResponseEntity.ok("Admin password changed successfully");
        } catch (WrongDataInputException | DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteAccount(Long adminId) {
        try {
            this.service.deleteById(adminId);
            return ResponseEntity.ok("Admin account has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Admin with id: " + adminId + " does not exist");
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
