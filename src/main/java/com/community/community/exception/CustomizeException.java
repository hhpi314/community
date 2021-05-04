package com.community.community.exception;

public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(ICustomizeErrorCode e) {
        this.message = e.getMessage();
        this.code = e.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
