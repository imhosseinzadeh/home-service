package ir.maktab.homeservice.controller.order;

import ir.maktab.homeservice.domain.service.order.OrderService;
import ir.maktab.homeservice.dto.order.OfferDto;
import ir.maktab.homeservice.dto.order.OrderDto;
import ir.maktab.homeservice.exception.DataNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/submit")
    public ResponseEntity<OrderDto> submit(@RequestBody @Valid OrderDto orderDto) {
        OrderDto saved = this.service.save(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/detail/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        Optional<OrderDto> optLoaded = this.service.findById(orderId);
        return optLoaded
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @PutMapping("/detail/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long orderId, @RequestBody @Valid OrderDto dto) {
        dto.setId(orderId);
        Optional<OrderDto> optUpdated = this.service.update(dto);
        return optUpdated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }

    @DeleteMapping("/delete-order/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        try {
            this.service.deleteById(orderId);
            return ResponseEntity.ok("Order has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Order with id: " + orderId + " does not exist");
        }
    }

    @GetMapping("order-offers/{orderId}")
    public ResponseEntity<Set<OfferDto>> getOrderOffers(@PathVariable Long orderId) {
        Set<OfferDto> orderOffers = this.service.getOrderOffers(orderId);
        return ResponseEntity.ok(orderOffers);
    }

    @PostMapping("accept-offer/{orderId}/{offerId}")
    public ResponseEntity<String> acceptOffer(@PathVariable Long orderId, @PathVariable Long offerId) {
        try {
            this.service.acceptOffer(orderId, offerId);
            return ResponseEntity.ok("Offer by id:" + offerId + " accepted for Order by id:" + orderId);
        } catch (DataNotExistsException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

}
