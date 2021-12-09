package edu.unifacef.productload.batch.processors;

import edu.unifacef.productload.domains.FullData;
import edu.unifacef.productload.gateways.inputs.io.resources.CsvDataResource;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateFullDataProcessorConfig {

  @Bean
  public ItemProcessor<CsvDataResource, FullData> createFullDataProcessor() {
    return csvDataResource -> FullData.builder()
        .product(csvDataResource.toProductDomain())
        .price(csvDataResource.toPriceDomain())
        .inventory(csvDataResource.toInventoryDomain())
        .build();
  }

}
