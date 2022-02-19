package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.config.AppUnitTestConfig;
import ir.maktab.homeserviceprovider.model.user.CustomerModel;

import ir.maktab.homeserviceprovider.service.user.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest//find beans in repository layer
@ActiveProfiles(value = "test")
@SpringJUnitConfig(value = AppUnitTestConfig.class)//find beans in service layer
class CustomerServiceTest {

    @Autowired
    CustomerService service;

/*    @Test
    void updatePasswordById_PasswordChange_UpdatePassword() {
        CustomerModel customer = CustomerModel.customerBuilder()
                .firstname("iman")
                .lastname("hosseinzadeh")
                .password("12345678")
                .build();
        Long customerId = service.save(customer).getId();

        String newPass = "newPassword";
        service.updatePasswordById(customerId, newPass);

        if (service.load(customerId).isPresent()) {
            CustomerModel loadCustomer = service.load(customerId).get();
            assertEquals(loadCustomer.getPassword(), newPass);
        } else {
            fail("Customer not found");
        }
    }*/
}