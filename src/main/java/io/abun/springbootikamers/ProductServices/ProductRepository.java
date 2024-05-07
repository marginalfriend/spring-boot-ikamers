package io.abun.springbootikamers.ProductServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository // JpaRepository extends PagingAndSortingRepository it's like ListCrudRepository on steroid
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    List<ProductEntity> findAllByTitleLikeIgnoreCase(String title);
}
