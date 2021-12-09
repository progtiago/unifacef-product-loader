package edu.unifacef.productload.gateways.inputs.io.resources;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import edu.unifacef.productload.domains.Attribute;
import edu.unifacef.productload.domains.Inventory;
import edu.unifacef.productload.domains.Price;
import edu.unifacef.productload.domains.Product;
import java.util.List;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class CsvDataResource {

  private String code;
  private String name;
  private String description;
  private String brand;
  private String images;
  private String attributes;
  private Double priceFrom;
  private Double priceTo;
  private Integer inventoryPosition;

  public Product toProductDomain() {
    return Product.builder()
        .code(this.code)
        .name(this.name)
        .description(this.description)
        .brand(this.brand)
        .images(asList(StringUtils.split(this.images, "|")))
        .attributes(createAttributes(this.attributes))
        .build();
  }

  public Price toPriceDomain() {
    return Price.builder()
        .productCode(this.code)
        .from(this.priceFrom)
        .to(this.priceTo)
        .build();
  }

  public Inventory toInventoryDomain() {
    return Inventory.builder()
        .productCode(this.code)
        .position(this.inventoryPosition)
        .build();
  }

  private List<Attribute> createAttributes(final String attributesAsString) {
    return stream(StringUtils.split(attributesAsString, "|"))
        .map(str -> str.split("="))
        .map(keyValue -> new Attribute(keyValue[0], keyValue[1]))
        .collect(toList());
  }
}
