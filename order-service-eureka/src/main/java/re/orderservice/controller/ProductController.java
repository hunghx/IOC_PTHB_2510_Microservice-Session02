package re.orderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
public class ProductController {
    @GetMapping
    public ResponseEntity<List<String>> getAllOrders() {
        return ResponseEntity.ok().body(
                Arrays.asList(new String[]{"Sản phần 1", "Sản phần 2", "Sản phần 3"})
        );
    }
}
