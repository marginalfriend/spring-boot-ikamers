package io.abun.springbootikamers.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    @Override
    public List<CustomerRecord> findFilteredCustomers(String name, String phone, Date birth, Boolean membership) {
        return null;
    }

    @Override
    public CustomerRecord findByNameOrPhone(String name, String phone) {
        CustomerEntity ent = repository.findByNameIgnoreCaseOrPhone(name, phone);

        return new CustomerRecord(
                ent.getName(),
                ent.getPhone(),
                ent.getBirth(),
                ent.getMembership()
        );
    }

    @Override
    public CustomerRecord addNewCustomer(CustomerEntity customer) {
        CustomerEntity saved = repository.saveAndFlush(customer);

        return new CustomerRecord(
                saved.getName(),
                saved.getPhone(),
                saved.getBirth(),
                saved.getMembership()
        );
    }


}
