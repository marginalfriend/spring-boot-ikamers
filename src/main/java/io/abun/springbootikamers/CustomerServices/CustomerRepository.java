package io.abun.springbootikamers.CustomerServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID>, JpaSpecificationExecutor<CustomerEntity> {
    CustomerEntity findByNameIgnoreCaseOrPhone(String name, String phone);
    List<CustomerEntity> findAllByNameLikeIgnoreCase(String name);
    CustomerEntity findByBirth(Date date);
    List<CustomerEntity> findAllByMembership(Boolean isMember);
}
