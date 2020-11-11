package hu.uni.eku.afpc1.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class TransactionAlreadyExistsException extends Exception {

    public TransactionAlreadyExistsException() {
    }

    public TransactionAlreadyExistsException(String message) {
        super(message);
    }

    public TransactionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public TransactionAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
