package hu.unimiskolc.shopping.DTO;

import hu.unimiskolc.shopping.model.Order;

import java.util.List;

public class UserDTO {

    private String userId;
    private String name;
    private String password;
    private List<Order> orders;

    public UserDTO(String userId, String name, String password, List<Order> orders) {
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
