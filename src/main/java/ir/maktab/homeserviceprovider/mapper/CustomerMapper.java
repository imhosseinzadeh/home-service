package ir.maktab.homeserviceprovider.mapper;

import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto mapToDto(CustomerModel model);

    CustomerModel mapToModel(CustomerDto dto);

    void updateDtoByModel(CustomerModel model, @MappingTarget CustomerDto dto);

    void updateModelByDto(CustomerDto dto, @MappingTarget CustomerModel model);
}
