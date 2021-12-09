package edu.unifacef.productload.gateways.inputs.http.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -130292785026387590L;
    private List<String> errors = new ArrayList();
}
