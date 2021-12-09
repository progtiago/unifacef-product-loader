package edu.unifacef.productload.gateways.outputs.http;

import edu.unifacef.productload.domains.Price;
import edu.unifacef.productload.gateways.outputs.PriceApiGateway;
import edu.unifacef.productload.gateways.outputs.http.resources.PriceResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceApiGatewayHttpImpl implements PriceApiGateway {

  private final PriceApiFeignIntegration priceApiFeignIntegration;

  @Override
  public void send(final Price price) {
    this.priceApiFeignIntegration.send(price.getProductCode(), new PriceResource(price));
  }
}
