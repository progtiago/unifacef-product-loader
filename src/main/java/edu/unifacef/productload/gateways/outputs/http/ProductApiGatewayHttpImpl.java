package edu.unifacef.productload.gateways.outputs.http;

import edu.unifacef.productload.domains.Product;
import edu.unifacef.productload.gateways.outputs.ProductApiGateway;
import edu.unifacef.productload.gateways.outputs.http.resources.ProductResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductApiGatewayHttpImpl implements ProductApiGateway {

  private final ProductApiFeignIntegration productApiFeignIntegration;

  @Override
  public void send(final Product product) {
    this.productApiFeignIntegration.send(new ProductResource(product));
  }
}
