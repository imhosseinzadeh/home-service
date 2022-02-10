package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.config.AppUnitTestConfig;
import ir.maktab.homeserviceprovider.model.UserModel;
import ir.maktab.homeserviceprovider.model.UserModelStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest//find beans in repository layer
@ActiveProfiles(value = "test")
@SpringJUnitConfig(value = AppUnitTestConfig.class)//find beans in service layer
class UserServiceTest {

    @Autowired
    private UserService<UserModel> service;

    @Test
    void updatePasswordById_BeChange_IfPasswordUpdated() {
        UserModel user = UserModel.builder()
                .firstname("firstname")
                .lastname("lastname")
                .email("example@gmail.com")
                .password("password1234")
                .status(UserModelStatus.NEW)
                .build();
        Long userId = service.saveOrUpdate(user).getId();

        String newPass = "newPassword1234";
        service.updatePasswordById(userId, newPass);

        if (service.load(userId).isPresent()) {
            UserModel loadUser = service.load(userId).get();

            assertEquals(loadUser.getPassword(), newPass);
        } else {
            fail("User not found");
        }
    }

    @Test
    void findByEmail_BeFound_IfAUserSaved() {
        String userEmail = "example@gmail.com";
        UserModel user = UserModel.builder()
                .firstname("firstname")
                .lastname("lastname")
                .email(userEmail)
                .password("password1234")
                .status(UserModelStatus.NEW)
                .build();
        UserModel savedUser = service.saveOrUpdate(user);

        UserModel loadUser = service.findByEmail(userEmail);

        assertEquals(savedUser, loadUser);
    }

    @Test
    void findAllByFirstnameAndLastname_BeFound_IfAUserSaved() {
        String firstname = "firstname";
        String lastname = "lastname";
        UserModel user = UserModel.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email("example@gmail.com")
                .password("password1234")
                .status(UserModelStatus.NEW)
                .build();
        UserModel savedUser = service.saveOrUpdate(user);

        Pageable pageable = PageRequest.of(0, 10);
        Page<UserModel> userPage = service.findAllByFirstnameAndLastname(firstname, lastname, pageable);

        assertTrue(userPage.get().anyMatch(loadUser -> loadUser.equals(savedUser)));
    }
}