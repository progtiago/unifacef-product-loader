package edu.unifacef.productload.gateways.outputs.http.resources;

import edu.unifacef.productload.domains.Inventory;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryResource implements Serializable {

  private static final long serialVersionUID = -1836179551837631660L;

  private Integer position;

  public InventoryResource(final Inventory inventory) {
    this.position = inventory.getPosition();
  }
}
