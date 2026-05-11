package re.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import re.orderservice.dto.request.OrderCreateDto;
import re.orderservice.entity.Orders;
import re.orderservice.exception.DataConflictException;
import re.orderservice.service.IOrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final IOrderService orderService;
    @PostMapping
    public Orders createOrder(@RequestBody OrderCreateDto request) throws DataConflictException {
        // Đây là 1 producer
//        return orderService.createOrder(request);
        // ném 1 event vào topic của kafka broker
        // gửi 1 event với key là order-create, và dữ liệu là request
        kafkaTemplate.send("order-create", request);
        return null;
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable("id") String id) {
        return orderService.getOrderById(id);
    }
}
