package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.ProductServices.Product;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "sellers")
@Table(name = "sellers")
public record Seller(
        @Id
        UUID id,
        String name,
        @Transient
        @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
        Product products
) {
}
