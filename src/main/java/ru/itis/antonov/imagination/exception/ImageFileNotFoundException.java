package ru.itis.antonov.imagination.exception;

public class ImageFileNotFoundException extends WebApplicationException{

    public static final int DEFAULT_STATUS = 404;

    public ImageFileNotFoundException() {
        super(DEFAULT_STATUS);
    }

    public ImageFileNotFoundException(String message) {
        super(message, DEFAULT_STATUS);
    }

    public ImageFileNotFoundException(String message, Throwable cause) {
        super(message, cause, DEFAULT_STATUS);
    }

    public ImageFileNotFoundException(Throwable cause) {
        super(cause, DEFAULT_STATUS);
    }
}
