package hu.unimiskolc.shopping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public class Product {
    @NotBlank(message = "Product ID is mandatory")
    private String productId;
    @NotBlank(message = "Product Name is mandatory")
    private String productName;
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private Double productPrice;
    private int productStock;

    public Product(@JsonProperty("id")String productId,
                   @JsonProperty("name")String productName,
                   @JsonProperty("price")Double productPrice,
                   @JsonProperty("stock") int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
