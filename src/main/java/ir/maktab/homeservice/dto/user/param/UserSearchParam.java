package ir.maktab.homeservice.dto.user.param;

import ir.maktab.homeservice.domain.model.user.UserModelStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchParam {
    private String firstname;
    private String lastname;
    private UserModelStatus status;
    private Long serviceId;
}
