package edu.unifacef.productload.batch.readers;

import edu.unifacef.productload.gateways.inputs.io.resources.CsvDataResource;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ProductCsvReaderConfig {

  public static final String[] COLUMN_NAMES = {
      "code", "name", "description", "brand", "images", "attributes", "priceFrom", "priceTo", "inventoryPosition"};

  @Bean
  @StepScope
  public FlatFileItemReader<CsvDataResource> csvReader(
      @Value("#{jobParameters['csvFile']}") Resource csvFile) {
    return new FlatFileItemReaderBuilder<CsvDataResource>()
        .name("csvReader")
        .linesToSkip(1)
        .resource(csvFile)
        .delimited()
        .names(COLUMN_NAMES)
        .targetType(CsvDataResource.class)
        .build();
  }
}
