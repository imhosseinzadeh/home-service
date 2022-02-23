package ir.maktab.homeserviceprovider.dto.order;

import ir.maktab.homeserviceprovider.domain.model.order.OrderModelStatus;
import ir.maktab.homeserviceprovider.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends BaseDto<Long> {

    @NotNull(message = "OrderDto-customerId cannot be null")
    private Long customerId;

    @NotNull(message = "OrderDto-subServiceId cannot be null")
    private Long subServiceId;

    private OrderModelStatus status;

    @NotNull(message = "OrderDto-proposedPrice cannot be null")
    private BigDecimal proposedPrice;

    @NotBlank(message = "OrderDto-description cannot be blank")
    private String description;

    @NotBlank(message = "OrderDto-address cannot be blank")
    private String address;

    @NotNull(message = "OrderDto-dateTime cannot be blank")
    private LocalDateTime dateTime;
}
