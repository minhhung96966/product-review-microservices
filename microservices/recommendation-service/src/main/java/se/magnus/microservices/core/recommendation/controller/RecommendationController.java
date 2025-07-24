package se.magnus.microservices.core.recommendation.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.recommendation.Recommendation;
import se.magnus.api.core.recommendation.RecommendationApi;
import se.magnus.microservices.core.recommendation.service.RecommendationService;

@RestController
@RequiredArgsConstructor
public class RecommendationController implements RecommendationApi {

  private final RecommendationService recommendationService;

  @Override
  public Recommendation createRecommendation(Recommendation body) {
    return recommendationService.createRecommendation(body);
  }

  @Override
  public List<Recommendation> getRecommendations(int productId) {
    return recommendationService.getRecommendations(productId);
  }

  @Override
  public void deleteRecommendations(int productId) {
    recommendationService.deleteRecommendations(productId);
  }
}
