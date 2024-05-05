package io.abun.springbootikamers.SellerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    SellerService service;

    @PostMapping("/new")
    public Seller createNewSeller(@RequestBody Seller seller) {
        return service.createSeller(seller);
    }

    @GetMapping
    public Seller getSellerById(@RequestBody UUID sellerId) {
        return service.findSellerById(sellerId);
    }
}
