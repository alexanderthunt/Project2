package com.revature.project1.exceptions;

public class NotMatchingException extends RuntimeException {

    public NotMatchingException() {

        super("Unable to authorize connection");
    }

    public NotMatchingException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotMatchingException(String message, Throwable cause) {

        super(message, cause);
    }

    public NotMatchingException(String message) {

        super(message);
    }

    public NotMatchingException(Throwable cause) {

        super(cause);
    }
}
