package ir.maktab.homeserviceprovider.dto.order;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.model.order.OfferModel;
import ir.maktab.homeserviceprovider.model.order.OrderModelStatus;
import ir.maktab.homeserviceprovider.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.model.user.CustomerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends BaseDto<Long> {

    @NotNull(message = "OrderDto-customer cannot be null")
    private CustomerModel customer;

    @NotNull(message = "OrderDto-subService cannot be null")
    private SubServiceModel subService;

    @NotNull(message = "OrderDto-status cannot be null")
    private OrderModelStatus status;

    private Set<OfferModel> offers;

    @NotNull(message = "OrderDto-proposedPrice cannot be null")
    private BigDecimal proposedPrice;

    @NotBlank(message = "OrderDto-description cannot be blank")
    private String description;

    @NotBlank(message = "OrderDto-address cannot be blank")
    private String address;

    @NotNull(message = "OrderDto-dateTime cannot be blank")
    private LocalDateTime dateTime;
}
