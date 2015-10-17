package main;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private static final int MAXIMUM_VALUE_TO_CALCULATE = 1000;
	private static final int ZERO = 0;

	public static int add(String numbers) throws NegativeNumberException {
		if (numbers.isEmpty()) {
			return ZERO;
		}
		NumberCreator numberCreator = NumberCreator.create(numbers);
		if (numberCreator.containNegativeNumber()) {
			throw new NegativeNumberException(new ArrayList<Integer>());
		}
		List<Integer> numberAsList = numberCreator.getNumbersAsList(numbers);
		return calculate(numberAsList);
	}

	private static int calculate(List<Integer> numberAsList) {
		int sum = ZERO;
		for (Integer number : numberAsList) {
			if (number <= MAXIMUM_VALUE_TO_CALCULATE) {
				sum += number;
			}
		}
		return sum;
	}
}
