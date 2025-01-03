package com.code.factory.domain.etc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.factory.global.exhaustiveSearch.ExhaustiveSearch;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtcService {
	private final ExhaustiveSearch exhaustiveSearch;
	public String getExhaustiveSearch() {
		int[] numbers = {0, 1, 2, 3, 4, 5, 6};
		List<int[]> search = exhaustiveSearch.generateSearch(numbers, 5);
		return "yes";
	}

	private int add(int numberA, int numberB) {
		return numberA + numberB;
	}
}
