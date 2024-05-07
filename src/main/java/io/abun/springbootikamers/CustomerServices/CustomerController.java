package io.abun.springbootikamers.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping
    public CustomerRecord findByNameOrPhone(@RequestParam String name, @RequestParam String phone) {
        return service.findByNameOrPhone(name, phone);
    }

    @PostMapping
    public CustomerRecord create(@RequestBody CustomerEntity newCustomer) {
        return service.addNewCustomer(newCustomer);
    }
}
