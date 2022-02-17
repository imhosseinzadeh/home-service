package ir.maktab.homeserviceprovider.dto.service;

import ir.maktab.homeserviceprovider.dto.BaseDto;
import ir.maktab.homeserviceprovider.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ExpertServiceDto extends BaseDto<ExpertServiceModelId> {

    @NotNull(message = "ExpertServiceDto-expert can not be null")
    private ExpertModel expert;

    @NotNull(message = "ExpertServiceDto-service can not be null")
    private ServiceModel service;

    @PositiveOrZero(message = "ExpertServiceDto-experienceYears must be positive or zero")
    private Integer experienceYears;

    private Integer score;
}
