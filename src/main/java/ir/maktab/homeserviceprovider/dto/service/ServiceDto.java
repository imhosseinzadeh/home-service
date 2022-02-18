package ir.maktab.homeserviceprovider.dto.service;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServiceDto extends BaseDto<Long> {

    private Long id;

    @NotBlank(message = "ServiceDto-name cannot be blank")
    private String name;
}
