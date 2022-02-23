package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExpertMapper {

    ExpertDto mapToDto(ExpertModel model);

    ExpertModel mapToModel(ExpertDto dto);

    void updateDtoByModel(@MappingTarget ExpertDto dto, ExpertModel model);

    void updateModelByDto(@MappingTarget ExpertModel model, ExpertDto dto);

}
