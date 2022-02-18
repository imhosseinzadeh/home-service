package ir.maktab.homeserviceprovider.dto.service;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.model.service.ServiceModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SubServiceDto extends BaseDto<Long> {

    @NotBlank(message = "SubServiceDto-name cannot blank")
    private String name;

    @NotNull(message = "SubServiceDto cannot exists without service")
    private ServiceModel service;

    private BigDecimal basePrice;

    private String comment;
}