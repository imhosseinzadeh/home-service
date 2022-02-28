package ir.maktab.homeserviceprovider.dto.service;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExpertServiceDto extends BaseDto<ExpertServiceModelId> {

    @NotNull(message = "ExpertServiceDto-expertId can not be null")
    private Long expertId;

    @NotNull(message = "ExpertServiceDto-serviceId can not be null")
    private Long serviceId;

    @PositiveOrZero(message = "ExpertServiceDto-experienceYears must be positive or zero")
    private Integer experienceYears;

    private Integer score;
}
