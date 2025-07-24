package se.magnus.microservices.core.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import se.magnus.api.core.product.Product;
import se.magnus.api.exceptions.InvalidInputException;
import se.magnus.api.exceptions.NotFoundException;
import se.magnus.microservices.core.product.entity.ProductEntity;
import se.magnus.microservices.core.product.mapper.ProductMapper;
import se.magnus.microservices.core.product.repository.ProductRepository;
import se.magnus.util.http.ServiceUtil;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ServiceUtil serviceUtil;
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Product createProduct(Product body) {
        try {
            ProductEntity entity = mapper.apiToEntity(body);
            ProductEntity newEntity = repository.save(entity);

            log.debug("createProduct: entity created for productId: {}", body.getProductId());
            return mapper.entityToApi(newEntity);

        } catch (DataIntegrityViolationException ex) {
            if (ExceptionUtils.getRootCauseMessage(ex).contains("duplicate")) {
                throw new InvalidInputException("Duplicate key, Product Id: " + body.getProductId());
            }
            throw ex;
        }
    }

    public Product getProduct(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        ProductEntity entity = repository.findByProductId(productId)
                .orElseThrow(() -> new NotFoundException("No product found for productId: " + productId));

        Product response = mapper.entityToApi(entity);
        response.setServiceAddress(serviceUtil.getServiceAddress());

        log.debug("getProduct: found productId: {}", response.getProductId());

        return response;
    }

    public void deleteProduct(int productId) {
        log.debug("deleteProduct: tries to delete an entity with productId: {}", productId);
        repository.findByProductId(productId).ifPresent(repository::delete);
    }
}
