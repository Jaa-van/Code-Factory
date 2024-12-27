package com.code.factory.global.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.code.factory.global.response.DataResponse;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BusinessException.class)
	public ErrorResponse handleCustomException(BusinessException exception) {
		int statusCode = exception.getStatusCode();

		return ErrorResponse.builder()
			.code(String.valueOf(statusCode))
			.message(exception.getMessage())
			.build();
	}
}
