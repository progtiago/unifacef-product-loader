package edu.unifacef.productload.gateways.outputs;

import edu.unifacef.productload.domains.Price;

public interface PriceApiGateway {

  void send(Price price);

}
