package coder.victor.ecommercespring.config.handlers;

import coder.victor.ecommercespring.config.exceptions.ErrorCodeInterface;
import org.springframework.http.HttpStatus;

public enum GeneralErrorCode implements ErrorCodeInterface {
    UNKNOWN_ERROR("GEC_000", "Unknown error occurred", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_REQUEST("GEC_001", "Invalid request", HttpStatus.BAD_REQUEST),
    ENTITY_NOT_FOUND("GEC_002", "Entity not found", HttpStatus.NOT_FOUND),

    ;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    GeneralErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage () {
        return message;
    }
}
