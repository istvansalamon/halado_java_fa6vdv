package hu.unimiskolc.shopping.repository;

import hu.unimiskolc.shopping.model.Order;
import hu.unimiskolc.shopping.model.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private Map<String, Order> orderDatabase = new HashMap<>();

   /* public OrderRepositoryImpl() {
        this.orderDatabase = new HashMap<>();
    }*/

    public OrderRepositoryImpl(){
        orderDatabase.put("0L", new Order("0L", LocalDate.now(), Order.Status.PROCESSING,null));
        orderDatabase.put("1L", new Order("1L",LocalDate.of(2024,02,8), Order.Status.DELIVERED,null));
    }
    private Map<String, Product> productDatabase;

    public OrderRepositoryImpl(Map<String, Product> productDatabase) {
        this.productDatabase = productDatabase;
    }
    @Override
    public void createOrder(Order order) {
        orderDatabase.put(order.getOrderId(), order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDatabase.put(order.getOrderId(), order);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderDatabase.remove(orderId);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderDatabase.get(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderDatabase.values());
    }


}