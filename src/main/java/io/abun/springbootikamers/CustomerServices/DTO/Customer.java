package io.abun.springbootikamers.CustomerServices.DTO;

import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class    Customer {
    private UUID id;
    private String name;
    private String phone;
    private Date birth;
    private Boolean membership;
}
