package hu.unimiskolc.shopping.repository;

import hu.unimiskolc.shopping.model.Product;
import hu.unimiskolc.shopping.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<String, User> userDatabase = new HashMap<>();
    public UserRepositoryImpl(){
        userDatabase = new HashMap<>();
        userDatabase.put("0L", new User("0L","Elek Marsh","passwd",null));
        userDatabase.put("1L", new User("1L","mouse","login",null));
    }
    @Override
    public User findById(String userId) {
        return userDatabase.get(userId);
    }

    @Override
    public void save(User user) {
        userDatabase.put(user.getUserId(), user);
    }

    @Override
    public void deleteById(String userId) {
        userDatabase.remove(userId);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userDatabase.values());
    }

}
