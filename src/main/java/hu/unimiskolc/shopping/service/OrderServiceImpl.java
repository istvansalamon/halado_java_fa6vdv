package hu.unimiskolc.shopping.service;

import hu.unimiskolc.shopping.exception.InvalidOrderException;
import hu.unimiskolc.shopping.model.Order;
import hu.unimiskolc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.createOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderRepository.deleteOrder(orderId);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order.Status getOrderStatus(String orderId) throws InvalidOrderException {
        List<Order> allOrders = getAllOrders();
        for (Order order : allOrders) {
            if (order.getOrderId().equals(orderId)) {
                return order.getStatus();
            }
        }
        throw new InvalidOrderException("Order with ID " + orderId + " not found.");
    }


}


