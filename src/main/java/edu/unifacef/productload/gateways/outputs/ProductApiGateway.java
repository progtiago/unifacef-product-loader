package edu.unifacef.productload.gateways.outputs;

import edu.unifacef.productload.domains.Product;

public interface ProductApiGateway {

  void send(Product product);

}
