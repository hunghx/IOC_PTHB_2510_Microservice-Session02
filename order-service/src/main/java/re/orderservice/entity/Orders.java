package re.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import re.orderservice.constant.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
//@JsonIgnoreProperties({"userId"})
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;
    private String userId;
    @Column(precision = 10,scale = 2)
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime createdAt;

}
