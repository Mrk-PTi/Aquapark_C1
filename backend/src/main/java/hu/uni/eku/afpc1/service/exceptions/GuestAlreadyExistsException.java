package hu.uni.eku.afpc1.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class GuestAlreadyExistsException extends Exception {

    public GuestAlreadyExistsException() {
    }

    public GuestAlreadyExistsException(String message) {
        super(message);
    }

    public GuestAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuestAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public GuestAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
