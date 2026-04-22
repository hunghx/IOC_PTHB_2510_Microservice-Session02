package re.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderItemId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int quantity;
}
