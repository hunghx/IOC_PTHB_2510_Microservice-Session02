package re.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceEurekaApplication.class, args);
    }

}
