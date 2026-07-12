package coder.victor.ecommercespring.config.exceptions;

public class ApiException extends RuntimeException {
    private final ErrorCodeInterface errorCodeInterface;

    public ApiException(ErrorCodeInterface errorCodeInterface) {
        super(errorCodeInterface.getMessage());
        this.errorCodeInterface = errorCodeInterface;
    }

    public ApiException(ErrorCodeInterface errorCodeInterface, Throwable cause) {
        super(errorCodeInterface.getMessage(), cause);
        this.errorCodeInterface = errorCodeInterface;
    }

    public ErrorCodeInterface getErrorCodeInterface() {
        return errorCodeInterface;
    }
}
