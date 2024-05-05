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
    public SellerEntity createNewSeller(@RequestBody SellerEntity sellerEntity) {
        return service.createSeller(sellerEntity);
    }

    @GetMapping
    public SellerEntity getSellerById(@RequestBody UUID id) {
        return service.findSellerById(id);
    }

    @GetMapping("/{name}")
    public SellerEntity getSellerByName(@PathVariable String name) {
        return service.findByName(name);
    }
}
