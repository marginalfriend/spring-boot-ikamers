package io.abun.springbootikamers.TransactionServices;

import io.abun.springbootikamers.CustomerServices.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "t_transaction")
@Table(name = "t_transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
