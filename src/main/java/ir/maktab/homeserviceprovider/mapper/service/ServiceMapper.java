package ir.maktab.homeserviceprovider.mapper.service;

import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import ir.maktab.homeserviceprovider.mapper.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ServiceMapper extends AbstractMapper<ServiceModel, ServiceDto, Long> {

}
