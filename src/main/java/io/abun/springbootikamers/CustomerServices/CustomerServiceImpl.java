package io.abun.springbootikamers.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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
    public List<CustomerRecord> findByNameOrPhone(String name, String phone) {
        List<CustomerRecord> result = new ArrayList<>();

        List<CustomerEntity> entities = repository.findByNameLikeIgnoreCaseOrPhone(name, phone);

        entities.forEach(cus -> {
            result.add(new CustomerRecord(
                    cus.getName(),
                    cus.getPhone(),
                    cus.getBirth(),
                    cus.getMembership()
            ));
        });

        return result;
    }


}
