package com.code.factory.global.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
public class DataResponse<T> {
	@JsonInclude(NON_DEFAULT)
	private boolean success;

	@JsonInclude(NON_DEFAULT)
	private HttpStatus httpStatus;

	@JsonInclude(NON_DEFAULT)
	private String message;

	private T data;

	@JsonInclude(NON_DEFAULT)
	private int count;

	private DataResponse(T data) {
		this.data = data;
	}

	private DataResponse(T data, int count) {
		this.data = data;
		this.count = count;
	}

	private DataResponse(boolean success, HttpStatus httpStatus, T data) {
		this.success = success;
		this.httpStatus = httpStatus;
		this.data = data;
	}

	private DataResponse(boolean success, HttpStatus httpStatus,String message, T data) {
		this.success = success;
		this.httpStatus = httpStatus;
		this.message = message;
		this.data = data;
	}
	private DataResponse(boolean success, HttpStatus httpStatus,String message, T data, int count) {
		this.success = success;
		this.httpStatus = httpStatus;
		this.message = message;
		this.data = data;
		this.count = count;
	}

	public static <T> DataResponse<T> of(T data) {
		return new DataResponse<>(data);
	}

	public static <T> DataResponse<T> of(T data, int count) {
		return new DataResponse<>(data, count);
	}

	public static <T> DataResponse<T> of(boolean success, HttpStatus httpStatus, T data) {
		return new DataResponse<>(success, httpStatus, data);
	}

	public static <T> DataResponse<T> of(boolean success, HttpStatus httpStatus, String message, T data, int count) {
		return new DataResponse<>(success, httpStatus, message, data, count);
	}
}
