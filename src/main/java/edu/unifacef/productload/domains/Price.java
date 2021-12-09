package edu.unifacef.productload.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {

  private String productCode;
  private Double from;
  private Double to;

}
