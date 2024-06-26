package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.ProductServices.ProductEntity;
import io.abun.springbootikamers.ProductServices.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    SellerService service;

    @PostMapping
    public SellerRecord create(@RequestBody SellerEntity sellerEntity) {
        SellerEntity entity = service.create(sellerEntity);
        return new SellerRecord(
                entity.getName(),
                entity.getAddress()
        );
    }

    @GetMapping
    public SellerEntity getByName(@RequestParam(required = false) String name) {
        return service.findByName(name);
    }

    @GetMapping("/id")
    public SellerRecord getById(@RequestHeader(value = "id") UUID id) {
        SellerEntity entity = service.findById(id);
        return new SellerRecord(
                entity.getName(),
                entity.getAddress()
        );
    }

    @PutMapping
    public ProductRecord addProduct(@RequestBody ProductEntity product, @RequestParam String name) {
        return service.addProduct(product, name);
    }

    @DeleteMapping
    public void remove(@RequestBody SellerEntity seller) {
        service.remove(seller);
    }
}
