package se.magnus.microservices.core.recommendation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import se.magnus.api.core.recommendation.Recommendation;
import se.magnus.api.exceptions.InvalidInputException;
import se.magnus.microservices.core.recommendation.entity.RecommendationEntity;
import se.magnus.microservices.core.recommendation.mapper.RecommendationMapper;
import se.magnus.microservices.core.recommendation.repository.RecommendationRepository;
import se.magnus.util.http.ServiceUtil;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository repository;

    private final RecommendationMapper mapper;

    private final ServiceUtil serviceUtil;

    public Recommendation createRecommendation(Recommendation body) {
        try {
            RecommendationEntity entity = mapper.apiToEntity(body);
            RecommendationEntity newEntity = repository.save(entity);

            log.debug("createRecommendation: created a recommendation entity: {}/{}", body.getProductId(), body.getRecommendationId());
            return mapper.entityToApi(newEntity);

        } catch (DataIntegrityViolationException ex) {
            if (ExceptionUtils.getRootCauseMessage(ex).contains("duplicate")) {
                throw new InvalidInputException("Duplicate key, Product Id: " + body.getProductId() + ", Recommendation Id:" + body.getRecommendationId());
            }
            throw ex;
        }
    }

    public List<Recommendation> getRecommendations(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        List<RecommendationEntity> entityList = repository.findByProductId(productId);
        List<Recommendation> list = mapper.entityListToApiList(entityList);
        list.forEach(e -> e.setServiceAddress(serviceUtil.getServiceAddress()));

        log.debug("getRecommendations: response size: {}", list.size());

        return list;
    }


    public void deleteRecommendations(int productId) {
        log.debug("deleteRecommendations: tries to delete recommendations for the product with productId: {}", productId);
        repository.deleteAll(repository.findByProductId(productId));
    }
}
