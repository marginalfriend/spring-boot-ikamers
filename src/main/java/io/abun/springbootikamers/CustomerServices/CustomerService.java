package io.abun.springbootikamers.CustomerServices;

import io.abun.springbootikamers.CustomerServices.DTO.CustomerNoID;
import io.abun.springbootikamers.CustomerServices.DTO.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerNoID> findAllCustomer(Customer request);
    List<CustomerNoID> findAll(Customer request);
    CustomerNoID findByNameOrPhone(String name, String phone);
    CustomerNoID addNewCustomer(CustomerEntity customer);
}
