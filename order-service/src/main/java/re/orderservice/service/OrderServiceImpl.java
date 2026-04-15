package re.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.orderservice.constant.OrderStatus;
import re.orderservice.dto.request.OrderCreateDto;
import re.orderservice.dto.request.OrderItemDto;
import re.orderservice.entity.Orders;
import re.orderservice.entity.OrderItem;
import re.orderservice.exception.DataConflictException;
import re.orderservice.exception.DataNotFoundException;
import re.orderservice.mapper.OrderItemMapper;
import re.orderservice.repository.IOrderItemRepository;
import re.orderservice.repository.IOrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final IOrderRepository orderRepository;
    private final IOrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public Orders createOrder(OrderCreateDto request) throws DataConflictException{

        // Luồng xử lí ngoại lệ trước khi lưu vào CSDL
        // product ko tồn tại
        // userid ko tìm thấy
        // Trước khi lưu dữ liệu thì phải kiểm tra tồn tại, trùng lặp của dữ liệu trước , nếu ko hợp lệ thì ném ra ngoại lệ
        if (true){
            throw  new DataConflictException("user ko tồn tại");
//            throw new DataNotFoundException("Order Not Found");
        }
        // Order trước
        double total = request.getItems().stream()
                .mapToDouble(value -> value.getProductPrice().doubleValue()*value.getQuantity())
                .sum();
        System.out.println("total = " + total);
        Orders order = new Orders(null, request.getUserId(),new BigDecimal(total), OrderStatus.CREATED, LocalDateTime.now());
        orderRepository.save(order);

        // Lưu orderitem
        for (OrderItemDto item:  request.getItems()) {
            OrderItem en = orderItemMapper.mapToOrderItem(item);
            en.setOrder(order);
            orderItemRepository.save(en);
        }
        return order;
    }
}
