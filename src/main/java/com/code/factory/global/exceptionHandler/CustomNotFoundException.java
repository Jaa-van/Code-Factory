package com.code.factory.global.exceptionHandler;

public class CustomNotFoundException extends BusinessException {
    private static final String MESSAGE = " is not found";

    public CustomNotFoundException(String data) {
        super(data + MESSAGE);
    }
    @Override
    public int getStatusCode() {
        return 400;
    }
}
