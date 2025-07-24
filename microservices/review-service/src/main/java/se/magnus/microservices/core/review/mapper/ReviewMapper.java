package se.magnus.microservices.core.review.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se.magnus.api.core.review.Review;
import se.magnus.microservices.core.review.entity.ReviewEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "serviceAddress", ignore = true)
    Review entityToApi(ReviewEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    ReviewEntity apiToEntity(Review api);

    List<Review> entityListToApiList(List<ReviewEntity> entity);

    List<ReviewEntity> apiListToEntityList(List<Review> api);

}