package re.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import re.orderservice.constant.OrderHistoryEnum;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor@Getter
@Setter
@Entity
public class OrderStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderHistoryId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    @Enumerated(EnumType.STRING)
    private OrderHistoryEnum status;
    private LocalDateTime updatedAt;
}
