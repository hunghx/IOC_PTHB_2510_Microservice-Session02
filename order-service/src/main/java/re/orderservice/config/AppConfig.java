package re.orderservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // câu hình
public class AppConfig {
    // Bean OPENAPI
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .version("1.0")
                        .title("Order Service")
                        .contact(new Contact()
                                .name("Hung hx")
                                .email("hunghx@gmail.com")
                        )
                );
    }
}
