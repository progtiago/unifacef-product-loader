package edu.unifacef.productload.gateways.outputs.http.resources;

import edu.unifacef.productload.domains.Attribute;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttributeResource implements Serializable {

  private static final long serialVersionUID = -7891410303259079221L;

  private String key;
  private String value;

  public AttributeResource(final Attribute attribute) {
    this.key = attribute.getKey();
    this.value = attribute.getValue();
  }
}
