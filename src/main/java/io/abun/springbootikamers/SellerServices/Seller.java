package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.ProductServices.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.util.UUID;

public record Seller(
        @Id
        UUID id,
        String name,
        @Transient
        @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
        Product products
) {
}
