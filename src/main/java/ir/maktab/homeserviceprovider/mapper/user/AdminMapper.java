package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import ir.maktab.homeserviceprovider.mapper.AbstractGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class AdminMapper extends AbstractGenericMapper<AdminModel, Long> {

    public abstract AdminDto mapToDto(AdminModel model);

    public abstract AdminModel mapToModel(AdminDto dto);

    public abstract void updateDtoByModel(@MappingTarget AdminDto dto, AdminModel model);

    public abstract void updateModelByDto(@MappingTarget AdminModel model, AdminDto dto);

}
