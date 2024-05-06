package io.abun.springbootikamers.SellerServices;
import io.abun.springbootikamers.SellerServices.ProductServices.ProductEntity;

import java.util.List;
import java.util.UUID;

public interface SellerService {
    SellerEntity create(SellerEntity sellerEntity);
    SellerEntity update(SellerEntity seller);
    SellerEntity findById(UUID id);
    List<SellerEntity> findAll();
    SellerEntity findByName(String name);
    void remove(SellerEntity sellerEntity);
    List<ProductEntity> addProduct(ProductEntity product, String sellerName);
}
