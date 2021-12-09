package edu.unifacef.productload.gateways.outputs;

import edu.unifacef.productload.domains.Inventory;

public interface InventoryApiGateway {

  void send(Inventory inventory);

}
