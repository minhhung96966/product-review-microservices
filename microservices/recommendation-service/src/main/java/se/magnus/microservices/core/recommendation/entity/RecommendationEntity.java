package se.magnus.microservices.core.recommendation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recommendations", uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "recommendation_id"}))
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RecommendationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "recommendation_id", nullable = false)
    private int recommendationId;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String content;

    @Version
    private Integer version;

    public RecommendationEntity(int productId, int recommendationId, String author, int rating, String content) {
        this.productId = productId;
        this.recommendationId = recommendationId;
        this.author = author;
        this.rating = rating;
        this.content = content;
    }
}

