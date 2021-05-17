package ru.itis.antonov.imagination.exception;

public class NoSuchUserException extends WebApplicationException{

    public static final int DEFAULT_STATUS = 404;

    public NoSuchUserException() {
        super(DEFAULT_STATUS);
    }

    public NoSuchUserException(String message) {
        super(message, DEFAULT_STATUS);
    }

    public NoSuchUserException(String message, Throwable cause) {
        super(message, cause, DEFAULT_STATUS);
    }

    public NoSuchUserException(Throwable cause) {
        super(cause, DEFAULT_STATUS);
    }
}
