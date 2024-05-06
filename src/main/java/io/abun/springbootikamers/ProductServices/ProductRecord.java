package io.abun.springbootikamers.ProductServices;
public record ProductRecord(
        String title,
        String description,
        Double price,
        Integer stock,
        String sellerName
) {}
