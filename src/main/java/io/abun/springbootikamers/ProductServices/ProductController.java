package io.abun.springbootikamers.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/new")
    public ProductEntity createProduct(@RequestBody ProductEntity productRecord) {
        return service.createProduct(productRecord);
    }

    @GetMapping
    List<ProductRecord> findAll(
            @RequestParam(value = "search", required = false) String title,
            @RequestParam(value = "pmin", required = false) Double pmin,
            @RequestParam(value = "pmax", required = false) Double pmax,
            @RequestParam(value = "available", required = false) Boolean available)
    {
        return service.findFilteredProducts(title, pmin, pmax, available);
    }

//    @GetMapping("/page={page}")
//    public List<ProductEntity> findPaginatedProduct(@PathVariable Integer page) {
//        return service.findPaginatedProducts(page - 1);
//    }
}
