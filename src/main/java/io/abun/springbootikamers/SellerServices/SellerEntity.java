package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.ProductServices.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "sellers")
@Table(name = "sellers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
    @Transient
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    Product products;
}
