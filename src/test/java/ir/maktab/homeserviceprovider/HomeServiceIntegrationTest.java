package ir.maktab.homeserviceprovider;

import ir.maktab.homeserviceprovider.dto.user.ChangePasswordParam;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class HomeServiceIntegrationTest {

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int serverPort;

    @Test
    void signup_changePassword_getProfile() {
        //urls
        String signupUrl = createUrl("/customers/signup");
        String changePasswordUrl = createUrl("/customers/change-password/{0}");
        String getProfileUrl = createUrl("/customers/profile/{0}");

        //SIGNUP
        String email = "example@Email.com";
        String password = "password1234";
        CustomerDto signupRequest = new CustomerDto(email, password);


        ResponseEntity<CustomerDto> signupResponse = this.restTemplate
                .postForEntity(signupUrl, signupRequest, CustomerDto.class);

        CustomerDto signupResponseBody = signupResponse.getBody();
        Long id = signupResponseBody.getId();


        //asserts for response
        assertEquals(HttpStatus.CREATED, signupResponse.getStatusCode());

        //asserts for responseBody
        assertEquals(email, signupResponseBody.getEmail());
        assertEquals(password, signupResponseBody.getPassword());


        //CHANGE PASSWORD
        String newPassword = "newPassword1234";
        ChangePasswordParam passwordParam = new ChangePasswordParam(password, newPassword);


        this.restTemplate
                .put(changePasswordUrl, passwordParam, id);


        //GET PROFILE
        ResponseEntity<CustomerDto> getProfileResponse = this.restTemplate
                .getForEntity(getProfileUrl, CustomerDto.class, id);
        CustomerDto getProfileResponseBody = getProfileResponse.getBody();

        assertEquals(newPassword, getProfileResponseBody.getPassword());
    }

    private String createUrl(String path) {
        return "http://localhost:" + this.serverPort + path;
    }

}
