package com.code.factory.domain.test.exception;

import com.code.factory.global.exceptionHandler.BusinessException;

public class CustomerNameNullPointException extends BusinessException {
	private static final String MESSAGE = "customerName is required";

	public CustomerNameNullPointException() {
		super(MESSAGE);
	}

	@Override
	public int getStatusCode() {
		return 404;
	}
}
