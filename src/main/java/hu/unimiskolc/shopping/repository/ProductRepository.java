package hu.unimiskolc.shopping.repository;

import hu.unimiskolc.shopping.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    Product findById(String productId);
    void save(Product product);
    void deleteById(String productId);
    List<Product> findAll();
}
