package hu.unimiskolc.shopping.repository;

import hu.unimiskolc.shopping.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {

    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(String orderId);
    Order getOrderById(String orderId);
    List<Order> getAllOrders();
}
