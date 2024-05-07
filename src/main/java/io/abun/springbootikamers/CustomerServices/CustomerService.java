package io.abun.springbootikamers.CustomerServices;

import java.sql.Date;
import java.util.List;

public interface CustomerService {
    List<CustomerRecord> findFilteredCustomers(String name, String phone, Date birth, Boolean membership);
    CustomerRecord findByNameOrPhone(String name, String phone);

    CustomerRecord addNewCustomer(CustomerEntity customer);
}
