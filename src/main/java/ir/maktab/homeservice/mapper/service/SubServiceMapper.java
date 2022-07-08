package ir.maktab.homeservice.mapper.service;

import ir.maktab.homeservice.domain.model.service.SubServiceModel;
import ir.maktab.homeservice.dto.service.SubServiceDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ServiceMapper.class})
public abstract class SubServiceMapper extends AbstractMapper<SubServiceModel, SubServiceDto, Long> {

    @Mapping(target = "serviceId", source = "service.id")
    public abstract SubServiceDto mapToDto(SubServiceModel model);

    @Mapping(target = "service", source = "serviceId")
    public abstract SubServiceModel mapToModel(SubServiceDto dto);

    @Mapping(target = "serviceId", source = "service.id")
    public abstract void updateDtoByModel(@MappingTarget SubServiceDto dto, SubServiceModel model);

    @Mapping(target = "service", source = "serviceId")
    public abstract void updateModelByDto(@MappingTarget SubServiceModel model, SubServiceDto dto);

}
