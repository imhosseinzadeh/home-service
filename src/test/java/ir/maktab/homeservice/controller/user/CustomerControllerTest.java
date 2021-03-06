package ir.maktab.homeservice.controller.user;

import ir.maktab.homeservice.controller.AbstractRestControllerTest;
import ir.maktab.homeservice.domain.service.user.CustomerService;
import ir.maktab.homeservice.dto.user.CustomerDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@WebMvcTest(CustomerController.class)
class CustomerControllerTest extends AbstractRestControllerTest {

    private final String signupUrl = "/customers/signup";

    @MockBean
    private CustomerService service;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void signup() throws Exception {
        //request
        String email = "example@Email.com";
        String password = "password1234";
        CustomerDto registerDto = new CustomerDto(email, password);

        //mock service
        OngoingStubbing<CustomerDto> serviceResult = Mockito.when(service.save(any())).thenReturn(registerDto);

        mockMvc.perform(post(this.signupUrl)
                        .content(writeJson(registerDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.password").value(password));
    }

    @Test
    void getProfile() {
    }

    @Test
    void updateProfile() {
    }

    @Test
    void changePassword() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void handleValidationExceptions() {
    }
}