package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.dto.service.ExpertServiceDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import ir.maktab.homeserviceprovider.mapper.service.ServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ExpertMapper.class, ServiceMapper.class})
public abstract class ExpertServiceMapper extends AbstractGenericMapper<ExpertServiceModel, ExpertServiceModelId> {

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
