package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.config.AppUnitTestConfig;
import ir.maktab.homeserviceprovider.entity.User;
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
        Long userId = saveUser("").getId();

        String newPass = "newPassword";
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
        String userEmail = "user@gmail.com";
        User saveUser = saveUser(userEmail);

        User loadUser = service.findByEmail("user@gmail.com");

        assertEquals(saveUser, loadUser);
    }

    private User saveUser(String email) {
        User user = User.builder()
                .firstname("iman")
                .lastname("hosseinzadeh")
                .password("12345678")
                .email(email)
                .build();
        return service.saveOrUpdate(user);
    }
}