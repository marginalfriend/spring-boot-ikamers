package io.abun.springbootikamers.ProductServices;

import io.abun.springbootikamers.SellerServices.Seller;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.UUID;

public record Product(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        String title,
        @Nullable
        String description,
        Double price,
        @ManyToOne
        @JoinColumn(name = "seller_id")
        Seller seller
) {}
