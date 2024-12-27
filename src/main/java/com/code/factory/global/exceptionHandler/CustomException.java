package com.code.factory.global.exceptionHandler;

import org.springframework.http.HttpStatus;

public class CustomException extends BusinessException {

	public CustomException(String message) {
		super(message);
	}

	public int getStatusCode() {
		return 500;
	}
}
