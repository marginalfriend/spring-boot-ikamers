package io.abun.springbootikamers.SellerServices;
import java.util.List;
import java.util.UUID;

public interface SellerService {
    SellerEntity createSeller(SellerEntity sellerEntity);
    SellerEntity findSellerById(UUID id);
    List<SellerEntity> findPaginatedSeller();
    SellerEntity findByName(String name);
    void removeSeller(SellerEntity sellerEntity);
}
