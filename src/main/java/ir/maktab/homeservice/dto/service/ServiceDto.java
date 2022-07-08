package ir.maktab.homeservice.dto.service;

import ir.maktab.homeservice.dto.BaseDto;
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
    @NotBlank(message = "ServiceDto-name cannot be blank")
    private String name;
}
