package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.dto.service.ExpertServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExpertServiceMapper {

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "serviceId", source = "service.id")
    ExpertServiceDto mapToDto(ExpertServiceModel model);

    @Mapping(target = "expert.id", source = "expertId")
    @Mapping(target = "service.id", source = "serviceId")
    ExpertServiceModel mapToModel(ExpertServiceDto dto);

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "serviceId", source = "service.id")
    void updateDtoByModel(@MappingTarget ExpertServiceDto dto, ExpertServiceModel model);

    @Mapping(target = "expert.id", source = "expertId")
    @Mapping(target = "service.id", source = "serviceId")
    void updateModelByDto(@MappingTarget ExpertServiceModel model, ExpertServiceDto dto);

}
