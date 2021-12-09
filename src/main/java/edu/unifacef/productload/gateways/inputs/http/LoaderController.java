package edu.unifacef.productload.gateways.inputs.http;

import static edu.unifacef.productload.exceptions.MessageKey.IMPORT_FILE_ERROR;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import edu.unifacef.productload.exceptions.ImportException;
import edu.unifacef.productload.gateways.outputs.io.SaveFileGateway;
import edu.unifacef.productload.utils.MessageUtils;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wildfly.common.annotation.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/loader")
public class LoaderController {

  @Value("${imports.csv.folder}")
  private String baseFolder;

  private final SaveFileGateway saveFileGateway;
  private final MessageUtils messageUtils;
  private final JobLauncher jobLauncher;
  private final Job job;

  @PostMapping(consumes = {MULTIPART_FORM_DATA_VALUE, APPLICATION_JSON_VALUE})
  @ResponseStatus(ACCEPTED)
  public void importFile(
      @NotNull @RequestParam(value = "file") final MultipartFile file) {
    try {
      String fileName = saveFileGateway.save(file.getBytes());
      Map<String, JobParameter> parameters = new HashMap<>();
      parameters.put("csvFile", new JobParameter("file:import-folder" + "/" + fileName));
      jobLauncher.run(job, new JobParameters(parameters));
    } catch (Exception e) {
      throw new ImportException(messageUtils.getMessage(IMPORT_FILE_ERROR));
    }
  }

}
