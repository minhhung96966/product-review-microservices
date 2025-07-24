package se.magnus.microservices.core.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import se.magnus.api.core.product.Product;
import se.magnus.microservices.core.product.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    ProductEntity apiToEntity(Product api);

    @Mapping(target = "serviceAddress", ignore = true)
    Product entityToApi(ProductEntity entity);
}

