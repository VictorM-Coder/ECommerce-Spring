package coder.victor.ecommercespring.users.exceptions;

import coder.victor.ecommercespring.config.exceptions.ErrorCodeInterface;
import org.springframework.http.HttpStatus;

public enum UserErrorCode implements ErrorCodeInterface {
    USER_NOT_FOUND("UEC_001", "User not found", HttpStatus.NOT_FOUND),
    USER_EMAIL_ALREADY_EXISTS("UEC_002", "User email already exists", HttpStatus.BAD_REQUEST),
    USER_FIRSTNAME_CANNOT_BE_NULL_OR_EMPTY("UEC_003", "User first name cannot be null or empty", HttpStatus.BAD_REQUEST),
    USER_LASTNAME_CANNOT_BE_NULL_OR_EMPTY("UEC_004", "User last name cannot be null or empty", HttpStatus.BAD_REQUEST),
    USER_PASSWORD_CANNOT_BE_NULL_OR_EMPTY("UEC_005", "User password cannot be null or empty", HttpStatus.BAD_REQUEST),
    USER_BIRTH_DATE_CANNOT_BE_NULL("UEC_006", "User birth date cannot be null", HttpStatus.BAD_REQUEST),
    USER_EMAIL_CANNOT_BE_NULL_OR_EMPTY("UEC_007", "User email cannot be null or empty", HttpStatus.BAD_REQUEST),
    USER_ROLE_CANNOT_BE_NULL("UEC_008", "User role cannot be null", HttpStatus.BAD_REQUEST),
    ;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    UserErrorCode(String code, String message, HttpStatus httpStatus) {
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
