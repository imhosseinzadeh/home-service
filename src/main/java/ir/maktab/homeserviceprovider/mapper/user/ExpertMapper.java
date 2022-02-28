package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ExpertMapper extends AbstractGenericMapper<ExpertModel, Long> {

    public abstract ExpertDto mapToDto(ExpertModel model);

    public abstract ExpertModel mapToModel(ExpertDto dto);

    public abstract void updateDtoByModel(@MappingTarget ExpertDto dto, ExpertModel model);

    public abstract void updateModelByDto(@MappingTarget ExpertModel model, ExpertDto dto);

}
