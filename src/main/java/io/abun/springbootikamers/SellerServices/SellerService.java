package io.abun.springbootikamers.SellerServices;
import java.util.UUID;

public interface SellerService {
    SellerEntity createSeller(SellerEntity sellerEntity);
    SellerEntity findSellerById(UUID id);
    void removeSeller(SellerEntity sellerEntity);
}
