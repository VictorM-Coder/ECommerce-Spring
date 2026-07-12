package coder.victor.ecommercespring.config.handlers;

import coder.victor.ecommercespring.config.exceptions.ApiException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * Error details for exception handling using RFC-9457 pattern as reference.
 * @see <a href="https://datatracker.ietf.org/doc/html/rfc9457">RFC-9457</a>
 */
public record ErrorDetails(
    String code,
    String details,
    HttpStatus status,
    Instant timestamp,
    String path,
    String method
) {
    private static final String UNKNOWN_METHOD = "UNKNOWN_METHOD";
    public ErrorDetails(ApiException apiException, String path, HttpMethod method) {
        this(
                apiException.getErrorCodeInterface().getCode(),
                apiException.getMessage(),
                apiException.getErrorCodeInterface().getHttpStatus(),
                Instant.now(),
                path,
                method != null ? method.name() : UNKNOWN_METHOD
        );
    }
}
