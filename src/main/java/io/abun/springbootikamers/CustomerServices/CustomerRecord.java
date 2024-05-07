package io.abun.springbootikamers.CustomerServices;

import java.sql.Date;

public record CustomerRecord(
        String name,
        String phone,
        Date birth,
        Boolean membership
) {
}
