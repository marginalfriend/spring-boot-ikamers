package io.abun.springbootikamers.SellerServices.ProductServices;

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
    public List<ProductEntity> searchProductByName(String name) {
        return null;
    }

    @Override
    public List<ProductEntity> findPaginatedProducts(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ProductEntity> page = repository.findAll(pageable);
        return page.getContent();
    }


    @Override
    public List<ProductEntity> findPaginatedProducts(Integer pageNo) {
        // Setting 10 as a default page size
        return findPaginatedProducts(pageNo, 10);
    }

    @Override
    public ProductEntity getProductById(UUID id) {
        Optional<ProductEntity> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override // Save and flush will immediately flush dem product into database
    public ProductEntity createProduct(ProductEntity productRecord) {
        return repository.saveAndFlush(productRecord);
    }

    @Override
    public void deleteProduct(ProductEntity productRecord) {
        repository.delete(productRecord);
    }
}
