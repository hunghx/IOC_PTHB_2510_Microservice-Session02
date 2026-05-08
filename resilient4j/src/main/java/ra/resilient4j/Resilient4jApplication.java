package ra.resilient4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Resilient4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Resilient4jApplication.class, args);
    }

}
