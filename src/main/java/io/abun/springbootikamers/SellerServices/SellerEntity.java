package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.SellerServices.ProductServices.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity(name = "sellers")
@Table(name = "sellers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;
    String name;
    String address;
    @Transient
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    List<ProductEntity> products;
}
