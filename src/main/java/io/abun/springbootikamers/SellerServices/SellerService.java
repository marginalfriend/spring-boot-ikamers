package io.abun.springbootikamers.SellerServices;

import org.springframework.stereotype.Service;

import java.util.UUID;

public interface SellerService {
    Seller createSeller(Seller seller);
    Seller findSellerById(UUID id);
    void removeSeller(Seller seller);
}
