package ru.itis.antonov.imagination.exception;

public class NotOwnerException extends WebApplicationException{
    public static final int DEFAULT_STATUS = 403;

    public NotOwnerException() {
        super(DEFAULT_STATUS);
    }

    public NotOwnerException(String message) {
        super(message, DEFAULT_STATUS);
    }

    public NotOwnerException(String message, Throwable cause) {
        super(message, cause, DEFAULT_STATUS);
    }

    public NotOwnerException(Throwable cause) {
        super(cause, DEFAULT_STATUS);
    }
}
