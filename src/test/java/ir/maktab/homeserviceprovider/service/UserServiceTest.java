/*
  TEST METHOD NAME CONVENTION

  MethodName_ExpectedBehavior_StateUnderTest

  EXAMPLES:
  isAdult_False_AgeLessThan18
  withdrawMoney_ThrowsException_IfAccountIsInvalid
  admitStudent_FailToAdmit_IfMandatoryFieldsAreMissing
 */
package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.config.AppUnitTestConfig;
import ir.maktab.homeserviceprovider.model.user.UserModel;
import ir.maktab.homeserviceprovider.model.user.UserModelStatus;
import ir.maktab.homeserviceprovider.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest//find beans in repository layer
@ActiveProfiles(value = "test")
@SpringJUnitConfig(value = AppUnitTestConfig.class)//find beans in service layer
class UserServiceTest {

/*    @Autowired
    private UserService<UserModel> service;

    private final WalletModel wallet = new WalletModel();

    @Test
    void save_BeFound_IfAUserSaved() {
        UserModel savedUser = service.save(buildUser());
        Long userId = savedUser.getId();

        Optional<UserModel> loadedUserOpt = service.load(userId);
        if (loadedUserOpt.isPresent()) {
            UserModel loadedUser = loadedUserOpt.get();

            assertEquals(savedUser, loadedUser);
        } else {
            fail("User not found");
        }
    }

    @Test
    void saveAll_BeFound_IfUsersSaved() {
        List<UserModel> userList = build3User();

        service.saveAll(userList);

        Page<UserModel> page = service.findAllByPage(Pageable.ofSize(10));
        assertEquals(userList.size(), page.getTotalElements());

    }

    @Test
    void delete_NotFound_DeleteUser() {
        UserModel savedUser = service.save(buildUser());

        service.delete(savedUser);

        Optional<UserModel> loadUserOpt = service.load(savedUser.getId());
        if (loadUserOpt.isPresent()) {
            fail("User could not be deleted");
        }
    }

    @Test
    void findAll_EqualElementNumber_SaveThreeElement() {
        List<UserModel> userList = build3User();
        service.saveAll(userList);

        Page<UserModel> page = service.findAllByPage(Pageable.ofSize(10));

        assertEquals(userList.size(), page.getTotalElements());
    }

    @Test
    void updatePasswordById_BeChange_IfPasswordUpdated() {
        UserModel user = UserModel.builder()
                .firstname("firstname")
                .lastname("lastname")
                .email("example@gmail.com")
                .password("password1234")
                .status(UserModelStatus.NEW)
                .wallet(wallet)
                .build();
        Long userId = service.save(user).getId();

        String newPass = "newPassword1234";
        service.updatePasswordById(userId, newPass);

        Optional<UserModel> loadedUserOpt = service.load(userId);
        if (loadedUserOpt.isPresent()) {
            UserModel loadUser = loadedUserOpt.get();

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
                .wallet(wallet)
                .build();
        UserModel savedUser = service.save(user);

        UserModel loadedUser = service.findByEmail(userEmail);

        assertEquals(savedUser, loadedUser);
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
                .wallet(wallet)
                .build();
        UserModel savedUser = service.save(user);

        Pageable pageable = PageRequest.of(0, 10);
        Page<UserModel> userPage = service.findAllByFirstnameAndLastname(firstname, lastname, pageable);

        assertTrue(userPage.get().anyMatch(loadUser -> loadUser.equals(savedUser)));
    }

    private UserModel buildUser() {
        return UserModel.builder()
                .firstname("firstname")
                .lastname("lastname")
                .email("example@gmail.com")
                .password("password1234")
                .status(UserModelStatus.NEW)
                .wallet(wallet)
                .build();
    }

    private List<UserModel> build3User() {
        UserModel user1 = service.save(UserModel.builder()
                .email("example111@gmail.com")
                .password("password1234")
                .status(UserModelStatus.NEW)
                .wallet(wallet)
                .build());

        UserModel user2 = service.save(UserModel.builder()
                .email("example222@gmail.com")
                .password("password1234")
                .status(UserModelStatus.NEW)
                .wallet(wallet)
                .build());

        UserModel user3 = service.save(UserModel.builder()
                .email("example333@gmail.com")
                .password("password1234")
                .status(UserModelStatus.NEW)
                .wallet(wallet)
                .build());
        return List.of(user1, user2, user3);
    }*/
}