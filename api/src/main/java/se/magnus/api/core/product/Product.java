package se.magnus.api.core.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
  private int productId;
  private String name;
  private int weight;
  private String serviceAddress;
}
