package edu.unifacef.productload.domains;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  private String code;
  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<Attribute> attributes;

}
