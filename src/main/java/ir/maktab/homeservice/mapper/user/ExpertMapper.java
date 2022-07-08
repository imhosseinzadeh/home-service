package ir.maktab.homeservice.mapper.user;

import ir.maktab.homeservice.domain.model.user.ExpertModel;
import ir.maktab.homeservice.dto.user.ExpertDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ExpertMapper extends AbstractUserMapper<ExpertModel, ExpertDto> {

}
