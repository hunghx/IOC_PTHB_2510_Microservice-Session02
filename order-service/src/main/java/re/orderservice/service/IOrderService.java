package re.orderservice.service;

import re.orderservice.dto.request.OrderCreateDto;
import re.orderservice.entity.Orders;
import re.orderservice.exception.DataConflictException;

public interface IOrderService {
    Orders createOrder(OrderCreateDto request) throws DataConflictException;
}
