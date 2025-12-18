package spring.developer.gsms.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ApiErrorCode errorCode;

    public BusinessException(String message, ApiErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
