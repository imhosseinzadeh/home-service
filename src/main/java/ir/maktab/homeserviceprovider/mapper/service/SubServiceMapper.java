package ir.maktab.homeserviceprovider.mapper.service;

import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ServiceMapper.class})
public abstract class SubServiceMapper extends AbstractGenericMapper<SubServiceModel, SubServiceDto, Long> {

    @Override
    @Mapping(target = "service", source = "serviceId")
    public abstract SubServiceModel mapToModel(SubServiceDto dto);

}
