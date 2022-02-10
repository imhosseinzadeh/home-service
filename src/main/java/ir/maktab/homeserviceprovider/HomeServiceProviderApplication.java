package ir.maktab.homeserviceprovider;

import ir.maktab.homeserviceprovider.model.User;
import ir.maktab.homeserviceprovider.model.UserStatus;
import ir.maktab.homeserviceprovider.service.ExpertService;

import ir.maktab.homeserviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class HomeServiceProviderApplication {

    @Autowired
    UserService<User> userService;

    @Autowired
    ExpertService expertService;

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args ->
        {
            User user = User.builder()
                    .firstname("iman")
                    .lastname("hosseinzadeh")
                    .password("abcd1234")
                    .email("ali@gmail.com")
                    .status(UserStatus.NEW)
                    .build();
            Long id = userService.saveOrUpdate(user).getId();

            Optional<User> user2 = userService.load(id);
            user2.ifPresent(System.out::println);
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
