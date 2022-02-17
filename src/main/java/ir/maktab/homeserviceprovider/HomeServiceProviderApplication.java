package ir.maktab.homeserviceprovider;

import ir.maktab.homeserviceprovider.model.user.UserModel;
import ir.maktab.homeserviceprovider.model.user.UserModelStatus;
import ir.maktab.homeserviceprovider.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.service.user.ExpertService;
import ir.maktab.homeserviceprovider.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootApplication
public class HomeServiceProviderApplication {

    @Autowired
    UserService<UserModel> userService;

    @Autowired
    ExpertService expertService;

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args ->
        {
            WalletModel wallet = new WalletModel();
            wallet.setBalance(BigDecimal.valueOf(10000));

            UserModel user = UserModel.builder()
                    .firstname("iman")
                    .lastname("hosseinzadeh")
                    .password("abcd1234")
                    .email("ali@gmail.com")
                    .status(UserModelStatus.NEW)
                    .wallet(wallet)
                    .build();

            Long id = userService.save(user).getId();

            Optional<UserModel> user2 = userService.load(id);
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
