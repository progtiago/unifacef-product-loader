package edu.unifacef.productload.gateways.outputs.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import edu.unifacef.productload.gateways.outputs.http.resources.ProductResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "product", url = "${integration.product.url}")
public interface ProductApiFeignIntegration {

  @PostMapping(path = "/api/v1/products", produces = APPLICATION_JSON_VALUE)
  void send(final ProductResource productResource);
}
