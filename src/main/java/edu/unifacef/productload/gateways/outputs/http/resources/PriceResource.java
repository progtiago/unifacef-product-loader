package edu.unifacef.productload.gateways.outputs.http.resources;

import edu.unifacef.productload.domains.Price;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceResource implements Serializable {

  private static final long serialVersionUID = 4100052587708572781L;

  private Double from;
  private Double to;

  public PriceResource(final Price price) {
    this.from = price.getFrom();
    this.to = price.getTo();
  }
}
