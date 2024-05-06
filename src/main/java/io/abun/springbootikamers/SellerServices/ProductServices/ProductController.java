package io.abun.springbootikamers.SellerServices.ProductServices;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public ProductController() {
    }

    public ProductService getService() {
        return service;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    // Methods -- Methods -- Methods -- Methods -- Methods -- Methods -- Methods -- Methods -- Methods

    @PostMapping("/new")
    public ProductEntity createProduct(@RequestBody ProductEntity productRecord) {
        return service.createProduct(productRecord);
    }

    @GetMapping("/page={page}")
    public List<ProductEntity> findPaginatedProduct(@PathVariable Integer page) {
        return service.findPaginatedProducts(page - 1);
    }
}
