package re.orderservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderCreateDto {
    private String userId;
    private List<OrderItemDto> items;
}
