package spring.developer.gsms.exception;

public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String message) {
        super(message, ApiErrorCode.RESOURCE_NOT_FOUND);
    }
}
