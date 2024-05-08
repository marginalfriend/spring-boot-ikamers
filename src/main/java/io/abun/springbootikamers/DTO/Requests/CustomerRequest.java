package io.abun.springbootikamers.DTO.Requests;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String name;
    private String phone;
    private Date birth;
    private Boolean membership;
}
