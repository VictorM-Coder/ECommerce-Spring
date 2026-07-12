package coder.victor.ecommercespring.documents.exceptions;

import coder.victor.ecommercespring.config.exceptions.ErrorCodeInterface;
import org.springframework.http.HttpStatus;

public enum DocumentsErrorCode implements ErrorCodeInterface {
    DOCUMENT_NOT_FOUND("DEC_001", "Document not found", HttpStatus.NOT_FOUND),
    DOCUMENT_URL_CANNOT_BE_NULL_OR_EMPTY("DEC_002", "Document url cannot be null or empty", HttpStatus.BAD_REQUEST),

    ;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    DocumentsErrorCode(String code, String message, HttpStatus httpStatus) {
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
    public String getMessage() {
        return message;
    }
}
