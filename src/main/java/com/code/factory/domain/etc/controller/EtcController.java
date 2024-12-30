package com.code.factory.domain.etc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.code.factory.domain.etc.exception.CustomerNameNullPointException;
import com.code.factory.domain.etc.service.EtcService;
import com.code.factory.global.response.DataResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class EtcController {
	private final EtcService etcService;

	/***
	 * 완전탐색
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/exhaustive-search")
	public DataResponse<String> testExhaustiveSearch() {
		String response = etcService.getExhaustiveSearch();
		return DataResponse.of(true, HttpStatus.OK, response);
	}

	@GetMapping("/error")
	public DataResponse<String> testError() throws CustomerNameNullPointException {
		throw new CustomerNameNullPointException();
	}
}
