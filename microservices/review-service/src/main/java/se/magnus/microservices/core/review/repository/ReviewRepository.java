package se.magnus.microservices.core.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import se.magnus.microservices.core.review.entity.ReviewEntity;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Transactional(readOnly = true)
    List<ReviewEntity> findByProductId(int productId);
}
