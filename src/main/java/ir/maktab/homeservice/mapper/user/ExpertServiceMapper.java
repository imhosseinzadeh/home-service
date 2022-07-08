package ir.maktab.homeservice.mapper.user;

import ir.maktab.homeservice.domain.model.service.ExpertServiceModel;
import ir.maktab.homeservice.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeservice.dto.service.ExpertServiceDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import ir.maktab.homeservice.mapper.service.ServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ExpertMapper.class, ServiceMapper.class})
public abstract class ExpertServiceMapper extends AbstractMapper<ExpertServiceModel, ExpertServiceDto, ExpertServiceModelId> {

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "serviceId", source = "service.id")
    public abstract ExpertServiceDto mapToDto(ExpertServiceModel model);

    @Mapping(target = "expert", source = "expertId")
    @Mapping(target = "service", source = "serviceId")
    public abstract ExpertServiceModel mapToModel(ExpertServiceDto dto);

    @Mapping(target = "expertId", source = "expert.id")
    @Mapping(target = "serviceId", source = "service.id")
    public abstract void updateDtoByModel(@MappingTarget ExpertServiceDto dto, ExpertServiceModel model);

    @Mapping(target = "expert", source = "expertId")
    @Mapping(target = "service", source = "serviceId")
    public abstract void updateModelByDto(@MappingTarget ExpertServiceModel model, ExpertServiceDto dto);

}
