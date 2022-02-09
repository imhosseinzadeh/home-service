package ir.maktab.homeserviceprovider;

import ir.maktab.homeserviceprovider.entity.Customer;
import ir.maktab.homeserviceprovider.entity.Expert;
import ir.maktab.homeserviceprovider.service.CustomerService;
import ir.maktab.homeserviceprovider.service.ExpertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
            Customer customer = Customer.customerBuilder()
                    .firstname("iman")
                    .lastname("hosseinzadeh").
                    password("1234").
                    build();
            customerService.saveOrUpdate(customer);

            Thread.sleep(10000);

            Optional<Customer> customer2 = customerService.load(1L);
            if (customer2.isPresent()) {
                customer2.get().setEmail("eeej");
                customerService.saveOrUpdate(customer2.get());
            }
        };
/*
        return args -> {
            System.out.println("Hibernate save image into database");

            File file = new File("D:\\photo_2022-02-07_14-29-22.jpg");
            byte[] bFile = new byte[(int) file.length()];

            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                //convert file into array of bytes
                fileInputStream.read(bFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Expert expert = Expert.expertBuilder()
                    .image(bFile)
                    .password("1234")
                    .build();

            Expert savedExpert = expertService.saveOrUpdate(expert);

            Optional<Expert> expert2 = expertService.load(savedExpert.getId());
            byte[] bExpert = expert2.get().getImage();

            try (FileOutputStream fos = new FileOutputStream("D:\\test5.jpg")) {
                fos.write(bExpert);
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
*/
    }
}
