package io.abun.springbootikamers.SellerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    SellerService service;

    @PostMapping
    public SellerEntity create(@RequestBody SellerEntity sellerEntity) {
        return service.create(sellerEntity);
    }

    @GetMapping
    public List<SellerEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{name}")
    public SellerEntity getByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @DeleteMapping
    public void remove(@RequestBody SellerEntity seller) {
        service.remove(seller);
    }

    @PutMapping
    public SellerEntity update(@RequestBody SellerEntity seller) {
        return service.update(seller);
    }
}
