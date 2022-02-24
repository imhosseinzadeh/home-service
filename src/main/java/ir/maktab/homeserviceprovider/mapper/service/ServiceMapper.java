package ir.maktab.homeserviceprovider.mapper.service;

import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceDto mapToDto(ServiceModel model);

    ServiceModel mapToModel(ServiceDto dto);

    void updateDtoByModel(@MappingTarget ServiceDto dto, ServiceModel model);

    void updateModelByDto(@MappingTarget ServiceModel model, ServiceDto dto);

}
