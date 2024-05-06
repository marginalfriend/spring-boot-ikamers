package io.abun.springbootikamers.SellerServices;
// Records cannot be entities since they are immutable, however they are a good fit to be a DTO
public record SellerRecord(
        String name,
        String address
) {
}
