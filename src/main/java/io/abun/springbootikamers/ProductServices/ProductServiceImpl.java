package io.abun.springbootikamers.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public List<ProductEntity> findFilteredProducts(String title, Double pmin, Double pmax, Boolean available) {
        if (title == null) {
            return repository.findAll();
        }

        List<ProductEntity> primarySearch = repository.findAllByTitleLike('%' + title + '%');

        // Filter functions
        Predicate<ProductEntity> minPrice = product -> product.getPrice() > pmin;
        Predicate<ProductEntity> maxPrice = product -> product.getPrice() < pmax;
        Predicate<ProductEntity> isAvailable = product -> product.getStock() > 0;

        // Shitload of conditionals
        if (pmin != null) {
            primarySearch = primarySearch.stream().filter(minPrice).toList();
        }

        if (pmax != null) {
            primarySearch = primarySearch.stream().filter(maxPrice).toList();
        }

        if (available != null) {
            primarySearch = primarySearch.stream().filter(isAvailable).toList();
        }

        // If null, it will return findAll
        return Objects.requireNonNullElseGet(primarySearch, () -> repository.findAll());
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
