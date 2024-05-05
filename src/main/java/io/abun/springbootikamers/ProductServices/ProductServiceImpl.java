package io.abun.springbootikamers.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductServiceImpl() {
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    // --- + --- + --- Methods --- + --- + ---

    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> findPaginatedProducts(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> page = repository.findAll(pageable);
        return page.getContent();
    }


    @Override
    public List<Product> findPaginatedProducts(Integer pageNo) {
        // Setting 10 as a default page size
        return findPaginatedProducts(pageNo, 10);
    }

    @Override
    public Product getProductById(UUID id) {
        Optional<Product> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override // Save and flush will immediately flush dem product into database
    public Product createProduct(Product product) {
        return repository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.delete(product);
    }
}
