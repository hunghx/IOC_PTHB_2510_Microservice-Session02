package re.orderservice.service;

import re.orderservice.dto.request.OrderCreateDto;
import re.orderservice.entity.Orders;
import re.orderservice.exception.DataConflictException;
import re.orderservice.exception.DataNotFoundException;

public interface IOrderService {
    Orders createOrder(OrderCreateDto request) throws DataConflictException;
    Orders getOrderById(String id) throws DataNotFoundException;
}
