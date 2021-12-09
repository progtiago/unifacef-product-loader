package edu.unifacef.productload.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullData {

  private Product product;
  private Price price;
  private Inventory inventory;

}
