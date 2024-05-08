package io.abun.springbootikamers.TransactionServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetailRepository, UUID> {
}
