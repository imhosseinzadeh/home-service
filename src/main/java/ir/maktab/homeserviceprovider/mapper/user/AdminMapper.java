package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDto mapToDto(AdminModel model);

    AdminModel mapToModel(AdminDto dto);

    void updateDtoByModel(@MappingTarget AdminDto dto, AdminModel model);

    void updateModelByDto(@MappingTarget AdminModel model, AdminDto dto);

}
