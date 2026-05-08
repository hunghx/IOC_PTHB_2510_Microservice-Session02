package ra.resilient4j;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/ships")
@RequiredArgsConstructor
public class ShipController {
    private final ShipService shipService;

    @GetMapping("/pay")
    public ResponseEntity<String> pay() {
        // gọi sang service để thực hiện check thanh toán
        return new ResponseEntity<>(shipService.checkPayment(),HttpStatus.OK);
    }

}
