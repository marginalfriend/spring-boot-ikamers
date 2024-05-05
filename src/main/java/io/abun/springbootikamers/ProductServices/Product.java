package io.abun.springbootikamers.ProductServices;

import io.abun.springbootikamers.SellerServices.SellerEntity;
import io.abun.springbootikamers.SellerServices.SellerRecord;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "products")
@Table(name = "products")
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
        SellerEntity seller
) {}
