package ir.maktab.homeserviceprovider;

import ir.maktab.homeserviceprovider.entity.Customer;
import ir.maktab.homeserviceprovider.service.CustomerService;
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

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args ->
        {
            Customer customer = Customer.customerBuilder()
                    .firstname("iman")
                    .lastname("hosseizadeh").
                    password("1234").
                    build();
            customerService.saveOrUpdate(customer);

            Thread.sleep(20000);

            Optional<Customer> customer2 = customerService.load(1L);
            if (customer2.isPresent()) {
                customer2.get().setEmail("eee");
                customerService.saveOrUpdate(customer2.get());
            }
        };
    }

}
