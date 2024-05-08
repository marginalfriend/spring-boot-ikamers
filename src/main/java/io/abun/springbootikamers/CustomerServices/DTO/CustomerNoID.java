package io.abun.springbootikamers.CustomerServices.DTO;

import java.sql.Date;

public record CustomerNoID(
        String name,
        String phone,
        Date birth,
        Boolean membership
) {}