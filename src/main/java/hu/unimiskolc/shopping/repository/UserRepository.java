package hu.unimiskolc.shopping.repository;

import hu.unimiskolc.shopping.model.User;

import java.util.List;

public interface UserRepository {
    public User findById(String userId);
    public void save(User user);
    public void deleteById(String userId);
    public List<User> findAll();
}
