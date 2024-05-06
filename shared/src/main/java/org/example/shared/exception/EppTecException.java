package org.example.shared.exception;

public class EppTecException extends RuntimeException {
    public EppTecException() {
    }

    public EppTecException(String message) {
        super(message);
    }

    public EppTecException(String message, Throwable cause) {
        super(message, cause);
    }

    public EppTecException(Throwable cause) {
        super(cause);
    }

    public EppTecException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
