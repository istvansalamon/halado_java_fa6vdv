package hu.unimiskolc.shopping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class User {
    @NotBlank(message = "User ID is mandatory")
    private String userId;
    @NotBlank(message = "User name is mandatory")
    private String name;
    @NotBlank(message = "User password is mandatory")
    private String password;
    private List<Order> orders;


    public User(@JsonProperty("userID")String userId,
                @JsonProperty("name")String name,
                @JsonProperty("password")String password,
                @JsonProperty("orders")List<Order> orders) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.orders = orders;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
