package ir.maktab.homeservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import ir.maktab.homeservice.util.ApplicationInfoUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(ApplicationInfoUtil.TITLE)
                        .description(ApplicationInfoUtil.DESCRIPTION)
                        .version(ApplicationInfoUtil.VERSION)
                        .license(ApplicationInfoUtil.LICENSE)
                        .contact(ApplicationInfoUtil.CONTACT)
                );
    }

}
