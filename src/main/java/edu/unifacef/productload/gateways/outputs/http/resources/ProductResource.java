package edu.unifacef.productload.gateways.outputs.http.resources;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.productload.domains.Product;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResource implements Serializable {

  private static final long serialVersionUID = -4761851866573069963L;

  private String code;
  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<AttributeResource> attributes;

  public ProductResource(final Product product) {
    this.code = product.getCode();
    this.name = product.getName();
    this.description = product.getDescription();
    this.brand = product.getBrand();
    this.images = product.getImages();
    this.attributes = emptyIfNull(product.getAttributes())
        .stream().map(AttributeResource::new).collect(toList());
  }
}
