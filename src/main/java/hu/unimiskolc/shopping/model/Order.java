package hu.unimiskolc.shopping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public class Order {

    public enum Status {
        NEW,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELED
    }
    @NotBlank(message = "Order Id is mandatory")
    private String orderId;
    private LocalDate orderDate;
    private Status status;
    private List<Product> productList;


    public Order(@JsonProperty("id")String orderId,
                 @JsonProperty("orderDate")LocalDate orderDate,
                 @JsonProperty("status")Status status,
                 @JsonProperty("products")List<Product> productList) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.productList = productList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
