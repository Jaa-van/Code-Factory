package com.code.factory.domain.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.code.factory.domain.test.service.TestService;
import com.code.factory.global.response.DataResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {
	private final TestService testService;

	/***
	 * 완전탐색
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/exhaustive-search")
	public DataResponse<String> testExhaustiveSearch() {
		String response = testService.getExhaustiveSearch();
		return DataResponse.of(true, HttpStatus.OK, response);
	}
}
