package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.config.AppUnitTestConfig;
import ir.maktab.homeserviceprovider.model.User;
import ir.maktab.homeserviceprovider.model.UserStatus;
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
    private UserService<User> service;

    @Test
    void updatePasswordById_BeChange_IfPasswordUpdated() {
        User user = User.builder()
                .firstname("firstname")
                .lastname("lastname")
                .email("example@gmail.com")
                .password("password1234")
                .status(UserStatus.NEW)
                .build();
        Long userId = service.saveOrUpdate(user).getId();

        String newPass = "newPassword1234";
        service.updatePasswordById(userId, newPass);

        if (service.load(userId).isPresent()) {
            User loadUser = service.load(userId).get();

            assertEquals(loadUser.getPassword(), newPass);
        } else {
            fail("User not found");
        }
    }

    @Test
    void findByEmail_BeFound_IfAUserSaved() {
        String userEmail = "example@gmail.com";
        User user = User.builder()
                .firstname("firstname")
                .lastname("lastname")
                .email(userEmail)
                .password("password1234")
                .status(UserStatus.NEW)
                .build();
        User savedUser = service.saveOrUpdate(user);

        User loadUser = service.findByEmail(userEmail);

        assertEquals(savedUser, loadUser);
    }

    @Test
    void findAllByFirstnameAndLastname_BeFound_IfAUserSaved() {
        String firstname = "firstname";
        String lastname = "lastname";
        User user = User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email("example@gmail.com")
                .password("password1234")
                .status(UserStatus.NEW)
                .build();
        User savedUser = service.saveOrUpdate(user);

        Pageable pageable = PageRequest.of(0, 10);
        Page<User> userPage = service.findAllByFirstnameAndLastname(firstname, lastname, pageable);

        assertTrue(userPage.get().anyMatch(loadUser -> loadUser.equals(savedUser)));
    }
}