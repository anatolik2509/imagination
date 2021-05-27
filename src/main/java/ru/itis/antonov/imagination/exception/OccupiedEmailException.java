package ru.itis.antonov.imagination.exception;

public class OccupiedEmailException extends WebApplicationException{

    public static final int DEFAULT_STATUS = 409;

    public static final String DEFAULT_MESSAGE = "";


    public OccupiedEmailException() {
        super(DEFAULT_MESSAGE, DEFAULT_STATUS);
    }

    public OccupiedEmailException(String message) {
        super(message, DEFAULT_STATUS);
    }

    public OccupiedEmailException(String message, Throwable cause) {
        super(message, cause, DEFAULT_STATUS);
    }

    public OccupiedEmailException(Throwable cause) {
        super(cause, DEFAULT_STATUS);
    }
}
