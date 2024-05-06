package io.abun.springbootikamers.SellerServices;
import io.abun.springbootikamers.ProductServices.ProductEntity;
import io.abun.springbootikamers.ProductServices.ProductRecord;

import java.util.List;
import java.util.UUID;

public interface SellerService {
    SellerEntity create(SellerEntity sellerEntity);
    SellerEntity update(SellerEntity seller);
    SellerEntity findById(UUID id);
    List<SellerEntity> findAll();
    SellerEntity findByName(String name);
    void remove(SellerEntity sellerEntity);
    ProductRecord addProduct(ProductEntity product, String sellerName);
}
