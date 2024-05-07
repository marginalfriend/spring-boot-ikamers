package io.abun.springbootikamers.CustomerServices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    static void resultShooter(List<CustomerRecord> result, List<CustomerEntity> raw) {
        raw.forEach(e -> {
            result.add(
                    new CustomerRecord(
                            e.getName(),
                            e.getPhone(),
                            e.getBirth(),
                            e.getMembership()
                    )
            );
        });
    };

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

        // A lambda function for collection's "foreach" method
        // We'll use it later for inserting query result of CustomerEntity into the CustomerRecord

        if (phone != null) {
            fromDb = fromDb.stream().filter(e -> e.getPhone().equals(phone)).toList();
        }

        if (birth != null) {
            fromDb = fromDb.stream().filter(e -> e.getBirth().equals(birth)).toList();
        }

        if (membership != null) {
            fromDb = fromDb.stream().filter(e -> e.getMembership().equals(membership)).toList();
        }

        resultShooter(result, fromDb);

        return result;
    }

    @Override
    public List<CustomerRecord> findAll(String name, String phone, Date birth, Boolean membership) {
        List<CustomerRecord> result = new ArrayList<>();

        Specification<CustomerEntity> spec = ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), '%' + name.toLowerCase() + '%'));
            }

            if (phone != null) {
                predicates.add(criteriaBuilder.equal(root.get("phone"), phone));
            }

            if (birth != null) {
                predicates.add(criteriaBuilder.equal(root.get("birth"), birth));
            }

            if (membership != null) {
                predicates.add(criteriaBuilder.equal(root.get("membership"), membership));
            }

            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        });

        resultShooter(result, repository.findAll(spec));

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
