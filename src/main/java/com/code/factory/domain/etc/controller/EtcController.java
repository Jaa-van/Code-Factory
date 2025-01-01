package com.code.factory.domain.etc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.code.factory.domain.etc.exception.CustomerNameNullPointException;
import com.code.factory.domain.etc.service.EtcService;
import com.code.factory.global.response.DataResponse;

import lombok.RequiredArgsConstructor;
import project.dto.ReservationStatusDTO;
import project.dto.ReservationStatusRequestDTO;
import com.code.factory.domain.etc.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class EtcController {
	private final EtcService etcService;

	private final ReservationService reservationService;

	@GetMapping("/reservation/search")
	@ResponseStatus(HttpStatus.OK)
	public DataResponse<List<ReservationStatusDTO>> getReservationStatus(ReservationStatusRequestDTO request) {
		List<ReservationStatusDTO> responses = reservationService.selectReservationStatus(request);
		return DataResponse.of(responses);
	}

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
	@ResponseStatus(HttpStatus.OK)
	public DataResponse<String> testError() throws CustomerNameNullPointException {
		throw new CustomerNameNullPointException();
	}
}
