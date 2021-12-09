package edu.unifacef.productload.gateways.outputs.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import edu.unifacef.productload.gateways.outputs.http.resources.PriceResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "price", url = "${integration.price.url}")
public interface PriceApiFeignIntegration {

  @PostMapping(path = "/api/v1/products/{productCode}/prices", produces = APPLICATION_JSON_VALUE)
  void send(@PathVariable("productCode") final String productCode,
            final PriceResource priceResource);
}
