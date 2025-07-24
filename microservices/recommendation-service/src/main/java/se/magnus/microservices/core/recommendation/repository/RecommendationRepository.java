package se.magnus.microservices.core.recommendation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.magnus.microservices.core.recommendation.entity.RecommendationEntity;
import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationEntity, Long> {
    @Transactional(readOnly = true)
    List<RecommendationEntity> findByProductId(int productId);
}

