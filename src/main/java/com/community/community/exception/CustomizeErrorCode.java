package com.community.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("你找的问题不见了，换一个试试？");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return null;
    }
}
