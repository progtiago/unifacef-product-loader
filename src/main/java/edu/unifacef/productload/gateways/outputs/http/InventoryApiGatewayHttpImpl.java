package edu.unifacef.productload.gateways.outputs.http;

import edu.unifacef.productload.domains.Inventory;
import edu.unifacef.productload.gateways.outputs.InventoryApiGateway;
import edu.unifacef.productload.gateways.outputs.http.resources.InventoryResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryApiGatewayHttpImpl implements InventoryApiGateway {

  private final InventoryApiFeignIntegration inventoryApiFeignIntegration;

  @Override
  public void send(final Inventory inventory) {
    this.inventoryApiFeignIntegration.send(
        inventory.getProductCode(), new InventoryResource(inventory));
  }

}
