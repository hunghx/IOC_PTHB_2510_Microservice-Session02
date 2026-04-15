package re.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.orderservice.entity.OrderItem;
@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItem, String> {
}
