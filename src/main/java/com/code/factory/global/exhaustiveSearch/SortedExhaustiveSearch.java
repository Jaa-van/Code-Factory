package com.code.factory.global.exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedExhaustiveSearch {
	public List<int[]> generateSortedSearch(int[] numbers, int length, long k) {
		List<int[]> result = new ArrayList<>();

		// 입력 배열을 정렬하여 사전순으로 시작
		Arrays.sort(numbers);

		// 사전순 순열 생성
		do {
			// 필요한 길이만큼 잘라서 저장
			int[] partial = Arrays.copyOf(numbers, length);
			result.add(partial);

			// 종료 조건: k 개만 생성
			if (result.size() == k) break;

		} while (nextPermutation(numbers));

		return result;
	}

	// 사전순으로 다음 순열 생성
	public boolean nextPermutation(int[] numbers) {
		int n = numbers.length;

		// 1. 뒤에서부터 감소하는 첫 번째 인덱스 찾기
		int i = n - 2;
		while (i >= 0 && numbers[i] >= numbers[i + 1]) {
			i--;
		}

		// 2. 더 이상 다음 순열이 없는 경우 (마지막 순열)
		if (i < 0) return false;

		// 3. i 뒤에 있는 가장 큰 값 중 numbers[i]보다 큰 값 찾기
		int j = n - 1;
		while (numbers[j] <= numbers[i]) {
			j--;
		}

		// 4. numbers[i]와 numbers[j]를 교환
		swap(numbers, i, j);

		// 5. i 이후를 오름차순으로 정렬
		reverse(numbers, i + 1, n - 1);

		return true;
	}

	// 배열 요소 교환
	public void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	// 배열 부분 뒤집기
	public void reverse(int[] numbers, int start, int end) {
		while (start < end) {
			swap(numbers, start, end);
			start++;
			end--;
		}
	}
}
