package ir.maktab.homeserviceprovider.controller.order;

import ir.maktab.homeserviceprovider.domain.service.order.OrderService;
import ir.maktab.homeserviceprovider.dto.order.OrderDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/submit")
    public ResponseEntity<OrderDto> submit(@RequestBody @Valid OrderDto dto) {
        OrderDto saved = this.service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //detail
    @GetMapping("/detail/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long id) {
        Optional<OrderDto> optLoaded = this.service.findById(id);
        return optLoaded
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @PutMapping("/detail/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderDto dto) {
        dto.setId(id);
        Optional<OrderDto> optUpdated = this.service.update(dto);
        return optUpdated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        try {
            this.service.deleteById(id);
            return ResponseEntity.ok("Order has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Order with id: " + id + " does not exist");
        }
    }
}
