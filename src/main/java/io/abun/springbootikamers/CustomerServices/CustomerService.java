package io.abun.springbootikamers.CustomerServices;

import java.sql.Date;
import java.util.List;

public interface CustomerService {
    List<CustomerRecord> findAllCustomer(CustomerRequest request);
    List<CustomerRecord> findAll(CustomerRequest request);
    CustomerRecord findByNameOrPhone(String name, String phone);
    CustomerRecord addNewCustomer(CustomerEntity customer);
}
