package ir.maktab.homeserviceprovider.mapper.service;

import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.repository.service.ServiceRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SubServiceMapper {

    @Autowired
    protected ServiceRepository serviceRepository;

    @Mapping(target = "serviceId", source = "service.id")
    public abstract SubServiceDto mapToDto(SubServiceModel model);

    @Mapping(target = "service", expression = "java(serviceRepository.findById(dto.getServiceId()).get())")
    public abstract SubServiceModel mapToModel(SubServiceDto dto);

    @Mapping(target = "serviceId", source = "service.id")
    public abstract void updateDtoByModel(@MappingTarget SubServiceDto dto, SubServiceModel model);

    @Mapping(target = "service", expression = "java(serviceRepository.findById(dto.getServiceId()).get())")
    public abstract void updateModelByDto(@MappingTarget SubServiceModel model, SubServiceDto dto);

}
