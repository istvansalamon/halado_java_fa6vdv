package hu.unimiskolc.shopping.repository;

import hu.unimiskolc.shopping.model.Product;
import hu.unimiskolc.shopping.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private Map<String, Product> productDatabase = new HashMap<>();
    public ProductRepositoryImpl(){
        productDatabase = new HashMap<>();
        productDatabase.put("0L", new Product("0L","keyboard",377.50,20));
        productDatabase.put("1L", new Product("1L","mouse",7.50,20));
    }


    @Override
    public Product findById(String productId) {
        return productDatabase.get(productId);
    }

    @Override
    public void save(Product product) {
        productDatabase.put(product.getProductId(), product);
    }

    @Override
    public void deleteById(String productId) {
        productDatabase.remove(productId);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productDatabase.values());
    }
}
