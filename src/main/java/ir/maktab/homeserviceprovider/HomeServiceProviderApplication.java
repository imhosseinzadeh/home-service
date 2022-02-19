package ir.maktab.homeserviceprovider;

import ir.maktab.homeserviceprovider.service.user.CustomerService;
import ir.maktab.homeserviceprovider.service.user.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeServiceProviderApplication {

    @Autowired
    CustomerService customerService;

    @Autowired
    ExpertService expertService;

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceProviderApplication.class, args);
    }
}

