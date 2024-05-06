package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.ProductServices.ProductRecord;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

// Records cannot be entities since they are immutable, however they are a good fit to be a DTO
public record SellerRecord(
        String name,
        String address
) {
}
