package edu.unifacef.productload.batch.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class ImportCsvJobConfig {

  private final JobBuilderFactory jobBuilderFactory;

  @Bean
  public Job importCsv(Step readerWriter) {
    return jobBuilderFactory.get("readerWriter")
        .start(readerWriter)
        .build();
  }
}
