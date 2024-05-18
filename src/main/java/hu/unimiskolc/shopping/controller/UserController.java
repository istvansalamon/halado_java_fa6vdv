package hu.unimiskolc.shopping.controller;

import hu.unimiskolc.shopping.DTO.UserDTO;
import hu.unimiskolc.shopping.exception.ResourceNotFoundException;
import hu.unimiskolc.shopping.model.User;
import hu.unimiskolc.shopping.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public void updateUser(@Valid @PathVariable String userId, @RequestBody User user) {

        userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/user/{usedId}")
    public User getUserById(@PathVariable String userId) throws ResourceNotFoundException {
        User user = userService.findById(userId);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with this ID: " + userId);
        }
        return user;
    }

}
