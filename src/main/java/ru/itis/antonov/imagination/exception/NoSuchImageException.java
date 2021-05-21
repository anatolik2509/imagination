package ru.itis.antonov.imagination.exception;

public class NoSuchImageException extends WebApplicationException{
    public static final int DEFAULT_STATUS = 404;

    public NoSuchImageException() {
        super(DEFAULT_STATUS);
    }

    public NoSuchImageException(String message) {
        super(message, DEFAULT_STATUS);
    }

    public NoSuchImageException(String message, Throwable cause) {
        super(message, cause, DEFAULT_STATUS);
    }

    public NoSuchImageException(Throwable cause) {
        super(cause, DEFAULT_STATUS);
    }
}
