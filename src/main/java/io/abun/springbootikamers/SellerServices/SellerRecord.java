package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.ProductServices.Product;
import jakarta.persistence.*;

import java.util.UUID;

// Records cannot be entities since they are immutable, however they are a good fit to be a DTO
public record SellerRecord(
        @Id
        UUID id,
        String name,
        @Transient
        @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
        Product products
) {
}
