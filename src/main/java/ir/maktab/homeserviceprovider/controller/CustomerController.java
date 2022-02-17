package ir.maktab.homeserviceprovider.controller;

import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.service.user.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup
            (@RequestBody @Valid CustomerDto signupRequest) {
        service.save2(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> get
            (@PathVariable Long id) {
        Optional<CustomerModel> resultOpt = service.load(id);
        if (resultOpt.isPresent()) {
            CustomerModel result = resultOpt.get();
            return ResponseEntity.ok(CustomerDto.builder()
                    .id(result.getId())
                    .email(result.getEmail())
                    .password(result.getPassword())
                    .build()
            );
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update
            (@PathVariable Long id, @RequestBody @Valid CustomerDto customerDto) {
        customerDto.setId(id);
        service.update2(customerDto);
        return null;
    }
}
