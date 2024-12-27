package com.code.factory.global.exceptionHandler;

public abstract class BusinessException extends RuntimeException {
	public BusinessException(String message) {
		super(message);
	}

	public abstract int getStatusCode();
}
