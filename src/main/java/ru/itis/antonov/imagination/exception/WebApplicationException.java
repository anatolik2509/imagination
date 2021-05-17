package ru.itis.antonov.imagination.exception;

public abstract class WebApplicationException extends RuntimeException{

    private final int status;

    public WebApplicationException(int status) {
        this.status = status;
    }

    public WebApplicationException(String message, int status) {
        super(message);
        this.status = status;
    }

    public WebApplicationException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    public WebApplicationException(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
