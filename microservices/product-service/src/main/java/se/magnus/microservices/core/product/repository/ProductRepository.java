package se.magnus.microservices.core.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.magnus.microservices.core.product.entity.ProductEntity;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Transactional(readOnly = true)
    Optional<ProductEntity> findByProductId(Integer productId);
}

