package io.abun.springbootikamers.CustomerServices;

import io.abun.springbootikamers.Auth.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "customers")
@Table(name = "customers")
@RequiredArgsConstructor
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String phone;

    @Column(nullable = false)
    Date birth;

    @Column(nullable = false)
    Boolean membership;

    @OneToOne
    @JoinColumn(name = "user_account_id", unique = true)
    UserAccount account;
}
