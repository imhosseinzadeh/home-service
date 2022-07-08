package ir.maktab.homeservice.mapper.service;

import ir.maktab.homeservice.domain.model.service.ServiceModel;
import ir.maktab.homeservice.dto.service.ServiceDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ServiceMapper extends AbstractMapper<ServiceModel, ServiceDto, Long> {

}
