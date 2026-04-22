package re.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.orderservice.dto.request.OrderCreateDto;
import re.orderservice.entity.Orders;
import re.orderservice.exception.DataConflictException;
import re.orderservice.service.IOrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;
    @PostMapping
    public Orders createOrder(@RequestBody OrderCreateDto request) throws DataConflictException {
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable("id") String id) {
        return orderService.getOrderById(id);
    }
}
