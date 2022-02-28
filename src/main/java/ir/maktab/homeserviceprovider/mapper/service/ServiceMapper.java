package ir.maktab.homeserviceprovider.mapper.service;

import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ServiceMapper extends AbstractGenericMapper<ServiceModel, Long> {

    public abstract ServiceDto mapToDto(ServiceModel model);

    public abstract ServiceModel mapToModel(ServiceDto dto);

    public abstract void updateDtoByModel(@MappingTarget ServiceDto dto, ServiceModel model);

    public abstract void updateModelByDto(@MappingTarget ServiceModel model, ServiceDto dto);

}
