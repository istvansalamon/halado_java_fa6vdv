package hu.unimiskolc.shopping.controller;

import hu.unimiskolc.shopping.exception.ProductNotFoundException;
import hu.unimiskolc.shopping.model.Product;
import hu.unimiskolc.shopping.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@Valid @RequestBody Product product){
        productService.createProduct(product);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable String productId, @RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable String productId){
        productService.deleteProductById(productId);
    }

    /*@GetMapping
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }*/


    @GetMapping
    public List<Product> getAllProducts() throws ProductNotFoundException {
        List<Product> products = productService.getAllProducts();
        if (products == null || products.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        }
        return products;
    }
}

