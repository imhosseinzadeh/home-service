package ir.maktab.homeserviceprovider.controller;

import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.exception.UserNotFoundException;
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
    public ResponseEntity<CustomerDto> signup(@RequestBody @Valid CustomerDto customerDto) {
        Optional<CustomerDto> optSaved = service.save(customerDto);
        return optSaved.map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto))
                .orElse(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getProfile
            (@PathVariable Long id) {
        Optional<CustomerDto> optLoaded = this.service.load(id);
        return optLoaded.map(ResponseEntity::ok)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateProfile
            (@PathVariable Long id, @RequestBody @Valid CustomerDto customerDto) {
        customerDto.setId(id);
        Optional<CustomerDto> optUpdated = this.service.update(customerDto);
        return optUpdated.map(ResponseEntity::ok).orElse(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        try {
            this.service.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Customer with id:" + id + " not found");
    }

}
