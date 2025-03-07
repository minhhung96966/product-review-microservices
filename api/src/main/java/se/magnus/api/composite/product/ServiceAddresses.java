package se.magnus.api.composite.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceAddresses {
  private String cmp;
  private String pro;
  private String rev;
  private String rec;
}
