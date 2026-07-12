package coder.victor.ecommercespring.config.exceptions;

import org.springframework.http.HttpStatus;

public interface ErrorCodeInterface {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
