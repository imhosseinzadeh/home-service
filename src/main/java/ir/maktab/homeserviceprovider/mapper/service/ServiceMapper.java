package ir.maktab.homeserviceprovider.mapper.service;

import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ServiceMapper extends AbstractGenericMapper<ServiceModel, ServiceDto, Long> {
    @Override
    protected ServiceModel map(Long id) {
        return super.map(id);
    }
}
