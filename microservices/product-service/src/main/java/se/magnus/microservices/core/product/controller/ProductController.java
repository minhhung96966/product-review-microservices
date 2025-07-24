package se.magnus.microservices.core.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.product.Product;
import se.magnus.api.core.product.ProductApi;
import se.magnus.microservices.core.product.service.ProductService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {
  private final ProductService productService;

  @Override
  public Product createProduct(Product body) {
    return productService.createProduct(body);
  }

  @Override
  public Product getProduct(int productId) {
    return productService.getProduct(productId);
  }

  @Override
  public void deleteProduct(int productId) {
    productService.deleteProduct(productId);
  }
}
