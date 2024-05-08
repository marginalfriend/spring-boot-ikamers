package io.abun.springbootikamers.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping
    public List<CustomerRecord> findAll (
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "birth", required = false) Date birth,
            @RequestParam(value = "membership", required = false) Boolean member
            ) {
        // Wrap it with dem DTO
        CustomerRequest request = CustomerRequest.builder()
                .name(name)
                .phone(phone)
                .birth(birth)
                .membership(member).build();

        // Send the package
        return service.findAll(request);
    }

    @PostMapping
    public CustomerRecord create(@RequestBody CustomerEntity newCustomer) {
        return service.addNewCustomer(newCustomer);
    }
}
