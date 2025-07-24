package se.magnus.microservices.core.review.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.review.Review;
import se.magnus.api.core.review.ReviewApi;
import se.magnus.microservices.core.review.service.ReviewService;

@RestController
@RequiredArgsConstructor
public class ReviewController implements ReviewApi {
  private final ReviewService reviewService;

  @Override
  public Review createReview(Review body) {
    return reviewService.createReview(body);
  }

  @Override
  public List<Review> getReviews(int productId) {
    return reviewService.getReviews(productId);
  }

  @Override
  public void deleteReviews(int productId) {
    reviewService.deleteReviews(productId);
  }
}
