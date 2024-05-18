package hu.unimiskolc.shopping.controller;

import hu.unimiskolc.shopping.exception.InvalidOrderException;
import hu.unimiskolc.shopping.exception.ProductPriceException;
import hu.unimiskolc.shopping.model.Order;
import hu.unimiskolc.shopping.model.Product;
import hu.unimiskolc.shopping.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/status/{orderId}")
    public Order.Status getOrderStatus(@PathVariable String orderId) throws InvalidOrderException {
        return orderService.getOrderStatus(orderId);
    }

    @PostMapping
    public void createOrder(@Valid @RequestBody Order order){
        orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


}

