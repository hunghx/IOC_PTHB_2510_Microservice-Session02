package re.shipservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // cach cũ ko chỉ áp dụng cho eureka
public class ShipServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipServiceApplication.class, args);
    }

}
