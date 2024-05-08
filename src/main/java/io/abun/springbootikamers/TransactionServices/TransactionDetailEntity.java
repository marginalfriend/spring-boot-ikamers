package io.abun.springbootikamers.TransactionServices;

import io.abun.springbootikamers.ProductServices.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity(name = "t_transaction_detail")
@Table(name = "t_transaction_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetailEntity {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transaction;
}
