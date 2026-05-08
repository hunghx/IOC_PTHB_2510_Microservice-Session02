package ra.resilient4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ShipService {
    // Thực hiện gọi thanh toán và giao hàng
    // Hàm chính : logic thực hiện bình thường
//    @CircuitBreaker(name = "payService", fallbackMethod = "fallBackCheckPayment")
//    @Retry(name = "payService", fallbackMethod ="fallBackCheckPayment")
    @TimeLimiter(name = "payService", fallbackMethod = "fallBackCheckPayment")
//    public CompletableFuture<String> callRemote() {
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000); // ⏱ simulate slow call (5s > timeout 2s)
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            return "real result";
//        });
//    }
//
//    public CompletableFuture<String> fallback(Throwable ex) {
//        return CompletableFuture.completedFuture("fallback: " + ex.getMessage());
//    }

    public String checkPayment(){
        // đa luông : Thread.sleep
        // chắc chắn sẽ thực hiện quá 10s
        try {
            Thread.sleep(10000);
//            throw new RuntimeException("Lỗi phát sinh");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Payment Success";
    }
    // hàm fallback : mạch dự phòng khi timeout
    public String fallBackCheckPayment(Exception e){
        return "Payment is waiting";
    }

}
