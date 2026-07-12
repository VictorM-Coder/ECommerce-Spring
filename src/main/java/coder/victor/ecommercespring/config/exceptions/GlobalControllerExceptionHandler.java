package coder.victor.ecommercespring.config.exceptions;

import coder.victor.ecommercespring.config.handlers.ErrorDetails;
import coder.victor.ecommercespring.config.handlers.GeneralErrorCode;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ErrorDetails handleApiException(ApiException ex, WebRequest request) {
        HttpMethod httpMethod = getHttpMethod(request);
        return new ErrorDetails(ex, request.getContextPath(), httpMethod);
    }

    @ExceptionHandler(Exception.class)
    public ErrorDetails handleGenericException(Exception ex, WebRequest request) {
        ApiException apiException = new ApiException(GeneralErrorCode.UNKNOWN_ERROR, ex);
        HttpMethod httpMethod = getHttpMethod(request);
        return new ErrorDetails(apiException, request.getContextPath(), httpMethod);
    }

    private static @Nullable HttpMethod getHttpMethod(WebRequest request) {
        if (request instanceof ServletWebRequest) {
            return ((ServletWebRequest) request).getHttpMethod();
        }
        return null;
    }
}
