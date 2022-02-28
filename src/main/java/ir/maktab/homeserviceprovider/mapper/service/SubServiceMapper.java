package ir.maktab.homeserviceprovider.mapper.service;

import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ServiceMapper.class})
public abstract class SubServiceMapper extends AbstractGenericMapper<SubServiceModel, Long> {

    @Mapping(target = "serviceId", source = "service.id")
    public abstract SubServiceDto mapToDto(SubServiceModel model);

    @Mapping(target = "service", source = "serviceId")
    public abstract SubServiceModel mapToModel(SubServiceDto dto);

    @Mapping(target = "serviceId", source = "service.id")
    public abstract void updateDtoByModel(@MappingTarget SubServiceDto dto, SubServiceModel model);

    @Mapping(target = "service", source = "serviceId")
    public abstract void updateModelByDto(@MappingTarget SubServiceModel model, SubServiceDto dto);

}
