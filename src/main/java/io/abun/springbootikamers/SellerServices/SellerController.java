package io.abun.springbootikamers.SellerServices;

import io.abun.springbootikamers.SellerServices.ProductServices.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    SellerService service;

    @PostMapping
    public SellerEntity create(@RequestBody SellerEntity sellerEntity) {
        return service.create(sellerEntity);
    }

//    @GetMapping
//    public List<SellerEntity> getAll() {
//        return service.findAll();
//    }

    @GetMapping
    public SellerEntity getByName(@RequestParam(required = false) String name) {
        return service.findByName(name);
    }

    @PutMapping
    public List<ProductEntity> addProduct(@RequestBody ProductEntity product,@RequestParam String name) {
        return service.addProduct(product, name);
    }

    @GetMapping("/id")
    public SellerEntity getById(@RequestHeader(value = "UUID") UUID id) {
        return service.findById(id);
    }

    @DeleteMapping
    public void remove(@RequestBody SellerEntity seller) {
        service.remove(seller);
    }

//    @PutMapping
//    public SellerEntity update(@RequestBody SellerEntity seller) {
//        return service.update(seller);
//    }
}
