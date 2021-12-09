package edu.unifacef.productload.gateways.outputs.io;

import static edu.unifacef.productload.exceptions.MessageKey.IMPORT_FILE_ERROR;

import edu.unifacef.productload.exceptions.ImportException;
import edu.unifacef.productload.utils.MessageUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveFileGateway {

  private final MessageUtils messageUtils;

  @Value("${imports.csv.folder}")
  private String baseFolder;

  public String save(final byte[] file) throws IOException {
    Path dir = Paths.get(baseFolder);
    String fileName = UUID.randomUUID().toString() + ".csv";
    if (!Files.exists(dir)) {
      Files.createDirectories(dir);
    }
    try (BufferedOutputStream stream =
             new BufferedOutputStream(
                 new FileOutputStream(new File(dir.toFile(), fileName)))) {
      stream.write(file);
      stream.flush();
      return fileName;
    } catch (Exception e) {
      throw new ImportException(messageUtils.getMessage(IMPORT_FILE_ERROR));
    }
  }
}
