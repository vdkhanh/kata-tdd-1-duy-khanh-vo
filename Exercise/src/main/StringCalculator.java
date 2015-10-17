package main;

import java.util.List;

public class StringCalculator {
	private static final int ZERO = 0;
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return ZERO;
		}
		NumberCreator numberCreator = NumberCreator.create(numbers);

		List<Integer> numberAsList = numberCreator.getNumbersAsList(numbers);
		return calculate(numberAsList);
	}
	private static int calculate(List<Integer> numberAsList) {
		int sum = ZERO;
		for (Integer number : numberAsList) {
			sum += number;
		}
		return sum;
	}
}
