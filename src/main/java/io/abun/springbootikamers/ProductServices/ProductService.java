package io.abun.springbootikamers.ProductServices;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    // Using "WHERE title LIKE"
    List<Product> searchProductByName(String name);
    Product getProductById(UUID id);
    Product createProduct(Product product);
    void deleteProduct(Product product);
}
