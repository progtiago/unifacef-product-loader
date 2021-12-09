package edu.unifacef.productload.batch.writers;

import edu.unifacef.productload.domains.FullData;
import edu.unifacef.productload.gateways.outputs.InventoryApiGateway;
import edu.unifacef.productload.gateways.outputs.PriceApiGateway;
import edu.unifacef.productload.gateways.outputs.ProductApiGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProductWriterConfig {

  private final ProductApiGateway productApiGateway;
  private final PriceApiGateway priceApiGateway;
  private final InventoryApiGateway inventoryApiGateway;

  @Bean
  public ItemWriter<FullData> productWriter() {
    return items -> items.forEach(fullData -> {
      productApiGateway.send(fullData.getProduct());
      priceApiGateway.send(fullData.getPrice());
      inventoryApiGateway.send(fullData.getInventory());
    });
  }
}
