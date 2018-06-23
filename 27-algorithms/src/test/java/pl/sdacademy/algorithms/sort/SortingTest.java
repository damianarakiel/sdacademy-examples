package pl.sdacademy.algorithms.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class SortingTest {
	private static Stream<Arguments> params() {
		return Stream.of(
			// input: {}, expected: {}
			Arguments.of(Collections.emptyList(), Collections.emptyList())
			// end of test cases
		);
	}

	@DisplayName("should sort input list ascending")
	@ParameterizedTest(name = "given input list = {0}, expected sorted list = {1}")
	@MethodSource(value = "params")
	void sort(List<Integer> input, List<Integer> expected) {
		// given
		Sorter sorter = new BubbleSorter();

		// when
		List<Integer> sortedList = sorter.sort(input);

		// then
		assertThat(sortedList).isEqualTo(expected);
	}
}
