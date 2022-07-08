package ir.maktab.homeservice.mapper.user;

import ir.maktab.homeservice.domain.model.user.AdminModel;
import ir.maktab.homeservice.dto.user.AdminDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AdminMapper extends AbstractUserMapper<AdminModel, AdminDto> {

}
