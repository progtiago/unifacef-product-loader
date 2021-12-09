package edu.unifacef.productload.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  IMPORT_FILE_ERROR("import.file.error");

  private String key;
}
