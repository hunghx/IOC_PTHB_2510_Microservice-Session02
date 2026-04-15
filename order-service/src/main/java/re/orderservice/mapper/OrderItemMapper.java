package re.orderservice.mapper;

import org.springframework.stereotype.Component;
import re.orderservice.dto.request.OrderCreateDto;
import re.orderservice.dto.request.OrderItemDto;
import re.orderservice.entity.OrderItem;

@Component
public class OrderItemMapper {
    public OrderItem mapToOrderItem(OrderItemDto request) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(request.getQuantity());
        orderItem.setProductId(request.getProductId());
        orderItem.setProductPrice(request.getProductPrice());
        orderItem.setProductName(request.getProductName());
        return orderItem;
    }
}
