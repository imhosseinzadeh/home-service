package ir.maktab.homeserviceprovider.dto.user.param;

import ir.maktab.homeserviceprovider.dto.service.ServiceDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchParam {
    private String firstname;
    private String Lastname;
    private ServiceDto service;
}
