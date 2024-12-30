package com.code.factory.global.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.code.factory.global.response.DataResponse;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(BusinessException exception) {
		int statusCode = exception.getStatusCode();

		ErrorResponse response = ErrorResponse.builder()
			.code(String.valueOf(statusCode))
			.message(exception.getMessage())
			.build();

		return ResponseEntity.status(statusCode)
			.body(response);
	}
}
