package hu.uni.eku.afpc1.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class SlideAlreadyExistsException extends Exception {

    public SlideAlreadyExistsException() {
    }

    public SlideAlreadyExistsException(String message) {
        super(message);
    }

    public SlideAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SlideAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public SlideAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}