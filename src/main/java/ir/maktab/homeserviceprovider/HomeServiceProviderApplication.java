package ir.maktab.homeserviceprovider;

import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import ir.maktab.homeserviceprovider.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.service.user.CustomerService;
import ir.maktab.homeserviceprovider.service.user.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class HomeServiceProviderApplication {

    @Autowired
    CustomerService customerService;

    @Autowired
    ExpertService expertService;

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args ->
        {
            CustomerDto dto = CustomerDto.builder()
                    .email("ali111@gmail.com")
                    .password("abc12345678")
                    .build();

            Long id = customerService.save(dto).getId();

            Optional<CustomerModel> customer2 = customerService.load(id);
            customer2.ifPresent(System.out::println);
        };
    }
}

