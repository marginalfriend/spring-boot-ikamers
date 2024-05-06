package io.abun.springbootikamers.SellerServices.ProductServices;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    // Using "WHERE title LIKE"
    List<ProductEntity> searchProductByName(String name);
    List<ProductEntity> findPaginatedProducts(Integer pageNo, Integer pageSize);
    List<ProductEntity> findPaginatedProducts(Integer pageNo);
    ProductEntity getProductById(UUID id);
    ProductEntity createProduct(ProductEntity productRecord);
    void deleteProduct(ProductEntity productRecord);
}
