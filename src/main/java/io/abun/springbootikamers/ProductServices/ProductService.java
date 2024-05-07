package io.abun.springbootikamers.ProductServices;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    // Using "WHERE title LIKE"
    List<ProductEntity> searchProductByName(String name);
    List<ProductEntity> findPaginatedProducts(Integer pageNo, Integer pageSize);
    List<ProductEntity> findPaginatedProducts(Integer pageNo);
    List<ProductRecord> findFilteredProducts(String title, Double pmin, Double pmax, Boolean available);
    ProductEntity getProductById(UUID id);
    ProductEntity createProduct(ProductEntity productRecord);
    void deleteProduct(ProductEntity productRecord);
}
