package med.voll.api.exception;

import org.springframework.http.HttpStatus;

public record ErrosResponse(
        HttpStatus httpStatus,
        String message
) {

}
