package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.config.AppUnitTestConfig;
import ir.maktab.homeserviceprovider.entity.User;
import ir.maktab.homeserviceprovider.entity.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    void updatePasswordById_PasswordChange_UpdatePassword() {
        Long userId = saveUser("alireza@gmail.com", "abcd1234", UserStatus.NEW).getId();

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
    void findByEmail_SavedUserAndLoadUserEqual_SaveAndLoadUser() {
        String userEmail = "alireza@gmail.com";
        User saveUser = saveUser(userEmail, "abcd1234", UserStatus.NEW);

        User loadUser = service.findByEmail(userEmail);

        assertEquals(saveUser, loadUser);
    }

    private User saveUser(String email, String password, UserStatus status) {
        User user = User.builder()
                .firstname("iman")
                .lastname("hosseinzadeh")
                .email(email)
                .password(password)
                .status(status)
                .build();
        return service.saveOrUpdate(user);
    }
}