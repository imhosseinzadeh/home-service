package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper extends AbstractGenericMapper<CustomerModel, Long> {

    public abstract CustomerDto mapToDto(CustomerModel model);

    public abstract CustomerModel mapToModel(CustomerDto dto);

    public abstract void updateDtoByModel(@MappingTarget CustomerDto dto, CustomerModel model);

    public abstract void updateModelByDto(@MappingTarget CustomerModel model, CustomerDto dto);

}
