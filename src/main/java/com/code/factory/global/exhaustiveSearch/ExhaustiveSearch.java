package com.code.factory.global.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExhaustiveSearch {

	public List<int[]> generateSearch(int[] numbers, int length) {
		List<int[]> result = new ArrayList<>();
		generateCount(numbers, 0, length, result);
		return result;
	}

	public void generateCount(int[] numbers, int start, int length, List<int[]> result) {
		if (start == length) {
			int[] partial = new int[length];
			System.arraycopy(numbers, 0, partial, 0, length);
			result.add(partial);
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			swap(numbers, start, i);

			generateCount(numbers, start + 1, length, result);

			swap(numbers, start, i);
		}
	}

	public void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
