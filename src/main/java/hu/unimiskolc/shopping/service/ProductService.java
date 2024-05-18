package hu.unimiskolc.shopping.service;

import hu.unimiskolc.shopping.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    Product findById(String productId);
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(String productId);
    List<Product> getAllProducts();

}

