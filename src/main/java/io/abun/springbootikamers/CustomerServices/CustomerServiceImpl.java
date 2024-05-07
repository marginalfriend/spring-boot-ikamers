package io.abun.springbootikamers.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    @Override
    public List<CustomerRecord> findAllCustomer(String name, String phone, Date birth, Boolean membership) {
        // Final result and query result container
        List<CustomerRecord> result = new ArrayList<>();
        List<CustomerEntity> fromDb;

        // Querying based on name parameter availability
        if (name == null) {
            fromDb = repository.findAll();
        } else {
            fromDb = repository.findAllByNameLikeIgnoreCase(name);
        }

        Consumer<CustomerEntity> resultShooter = e -> {
            result.add(
                    new CustomerRecord(
                            e.getName(),
                            e.getPhone(),
                            e.getBirth(),
                            e.getMembership()
                    )
            );
        };

        if (phone != null) {
            fromDb = fromDb.stream().filter(e -> e.getPhone().equals(phone)).toList();
        }

        if (birth != null) {
            fromDb = fromDb.stream().filter(e -> e.getBirth().equals(birth)).toList();
        }

        if (membership != null) {
            fromDb = fromDb.stream().filter(e -> e.getMembership().equals(membership)).toList();
        }

        fromDb.forEach(resultShooter);

        return result;
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
