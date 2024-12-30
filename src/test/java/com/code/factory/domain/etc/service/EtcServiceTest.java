package com.code.factory.domain.etc.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.code.factory.global.exhaustiveSearch.ExhaustiveSearch;

class EtcServiceTest {

	@Mock
	private ExhaustiveSearch exhaustiveSearch;

	@InjectMocks
	private EtcService etcService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getExhaustiveSearch_ShouldReturnYes() {
		// arrange
		int[] numbers = {0, 1, 2, 3, 4, 5};
		List<int[]> mockResult = new ArrayList<>();
		mockResult.add(new int[]{0, 1, 2, 3, 4});
		when(exhaustiveSearch.generateSearch(numbers, 5)).thenReturn(mockResult);

		String result = etcService.getExhaustiveSearch();

		assertEquals("yes", result);
	}
}