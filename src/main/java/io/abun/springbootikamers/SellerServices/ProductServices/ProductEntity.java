package io.abun.springbootikamers.SellerServices.ProductServices;

import io.abun.springbootikamers.SellerServices.SellerEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@RequiredArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;
    String title;
    @Nullable
    String description;
    Double price;
    Integer stock;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    SellerEntity seller;
}
