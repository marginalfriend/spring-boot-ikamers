package io.abun.springbootikamers.ProductServices;

import io.abun.springbootikamers.SellerServices.SellerEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String title;
    @Nullable
    String description;
    Double price;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    SellerEntity seller;
}
