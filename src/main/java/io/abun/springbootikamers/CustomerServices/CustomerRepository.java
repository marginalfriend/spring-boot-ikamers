package io.abun.springbootikamers.CustomerServices;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
    CustomerEntity findByPhone(String number);
    List<CustomerEntity> findAllByNameLike(String name);
    CustomerEntity findByBirth(Date date);
    List<CustomerEntity> findAllByMembership(Boolean isMember);
}
