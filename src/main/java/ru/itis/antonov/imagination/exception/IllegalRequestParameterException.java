package ru.itis.antonov.imagination.exception;

public class IllegalRequestParameterException extends WebApplicationException{

    public static final int DEFAULT_STATUS = 422;

    public static final String DEFAULT_MESSAGE = "";

    public IllegalRequestParameterException() {
        super(DEFAULT_MESSAGE, DEFAULT_STATUS);
    }

    public IllegalRequestParameterException(String message) {
        super(message, DEFAULT_STATUS);
    }

    public IllegalRequestParameterException(String message, Throwable cause) {
        super(message, cause, DEFAULT_STATUS);
    }

    public IllegalRequestParameterException(Throwable cause) {
        super(cause, DEFAULT_STATUS);
    }
}
