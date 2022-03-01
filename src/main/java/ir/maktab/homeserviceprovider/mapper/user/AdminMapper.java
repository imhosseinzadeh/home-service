package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.AdminModel;
import ir.maktab.homeserviceprovider.dto.user.AdminDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AdminMapper extends AbstractUserMapper<AdminModel, AdminDto> {

}
