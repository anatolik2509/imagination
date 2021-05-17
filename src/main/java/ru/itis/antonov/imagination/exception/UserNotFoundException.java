package ru.itis.antonov.imagination.exception;

public class UserNotFoundException extends WebApplicationException{

    public static final int DEFAULT_STATUS = 404;

    public UserNotFoundException() {
        super(DEFAULT_STATUS);
    }

    public UserNotFoundException(String message) {
        super(message, DEFAULT_STATUS);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause, DEFAULT_STATUS);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause, DEFAULT_STATUS);
    }
}
