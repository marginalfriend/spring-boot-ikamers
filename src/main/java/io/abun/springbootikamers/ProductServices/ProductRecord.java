package io.abun.springbootikamers.ProductServices;

import io.abun.springbootikamers.SellerServices.SellerEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.UUID;


public record ProductRecord(
        String title,
        String description,
        Double price,
        Integer stock,
        String sellerName
) {}
