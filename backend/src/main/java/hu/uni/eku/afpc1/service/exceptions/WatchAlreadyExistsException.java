package hu.uni.eku.afpc1.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class WatchAlreadyExistsException extends Exception {

    public WatchAlreadyExistsException() {
    }

    public WatchAlreadyExistsException(String message) {
        super(message);
    }

    public WatchAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatchAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public WatchAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}