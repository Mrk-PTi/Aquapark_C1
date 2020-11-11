package hu.uni.eku.afpc1.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class PayAlreadyExistsException extends Exception {

    public PayAlreadyExistsException() {
    }

    public PayAlreadyExistsException(String message) {
        super(message);
    }

    public PayAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public PayAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
