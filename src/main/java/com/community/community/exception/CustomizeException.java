package com.community.community.exception;

public class CustomizeException extends RuntimeException{
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(ICustomizeErrorCode e) {
        this.message = e.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }
}
