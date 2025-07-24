package se.magnus.microservices.core.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reviews", uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "review_id"}))
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "review_id", nullable = false)
    private int reviewId;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Version
    private Integer version;

    public ReviewEntity(int productId, int reviewId, String author, String subject, String content) {
        this.productId = productId;
        this.reviewId = reviewId;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }
}

