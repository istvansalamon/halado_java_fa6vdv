package hu.unimiskolc.shopping.service;

import hu.unimiskolc.shopping.exception.InvalidOrderException;
import hu.unimiskolc.shopping.exception.ProductPriceException;
import hu.unimiskolc.shopping.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(String orderId);
    Order getOrderById(String orderId);
    List<Order> getAllOrders();
    Order.Status getOrderStatus(String orderId)throws InvalidOrderException;

}
