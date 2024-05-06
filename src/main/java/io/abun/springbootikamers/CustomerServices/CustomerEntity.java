package io.abun.springbootikamers.CustomerServices;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
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
    String name;
    @Column(unique = true)
    String phone;
    Date birth;
    Boolean membership;
}
