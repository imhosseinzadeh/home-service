package ir.maktab.homeserviceprovider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args ->
        {

        };
    }

}
