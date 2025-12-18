package spring.developer.gsms.exception;

public class UnauthorizedException extends BusinessException {

    public UnauthorizedException(String message) {
        super(message, ApiErrorCode.UNAUTHORIZED);
    }
}
