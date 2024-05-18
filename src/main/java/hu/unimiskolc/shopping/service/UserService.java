package hu.unimiskolc.shopping.service;

import hu.unimiskolc.shopping.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findById(String userId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUserById(String userId);
    List<User> getAllUsers();
}
