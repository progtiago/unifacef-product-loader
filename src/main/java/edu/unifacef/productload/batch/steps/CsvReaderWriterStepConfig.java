package edu.unifacef.productload.batch.steps;

import edu.unifacef.productload.domains.FullData;
import edu.unifacef.productload.gateways.inputs.io.resources.CsvDataResource;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CsvReaderWriterStepConfig {

  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step readerWriter(ItemReader<CsvDataResource> csvReader,
                           ItemProcessor<CsvDataResource, FullData> createFullDataProcessor,
                           ItemWriter<FullData> productWriter) {
    return stepBuilderFactory.get("readerWriter")
        .<CsvDataResource, FullData>chunk(1)
        .reader(csvReader)
        .processor(createFullDataProcessor)
        .writer(productWriter)
        .build();
  }
}
