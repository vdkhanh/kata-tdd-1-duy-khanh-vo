package main;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberCreator {

	protected static final String SIGNAL_OF_CHANGE_DELIMITER = "//";
	protected String numbers;

	public abstract String getDelimiter();

	public abstract String getNumberAfterDelimiter();

	public List<Integer> getNegativeNumbers() {
		List<Integer> numberAsList = getNumbersAsList(numbers);
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (Integer number : numberAsList) {
			if (number < 0) {
				negativeNumbers.add(number);
			}
		}
		return negativeNumbers;
	}

	public List<Integer> getNumbersAsList(String numbers) {
		if (null == numbers || numbers.isEmpty()) {
			return new ArrayList<Integer>();
		}
		NumberCreator numberCreator = NumberCreator.create(numbers);
		return extractNumberByDelimiter(numberCreator.getDelimiter(), numberCreator.getNumberAfterDelimiter());
	}

	private List<Integer> extractNumberByDelimiter(String delimiter, String numberAfterDelimiter) {
		List<Integer> numbersAsList = new ArrayList<Integer>();
		for (String number : numberAfterDelimiter.split(delimiter)) {
			numbersAsList.add(Integer.parseInt(number));
		}
		return numbersAsList;
	}

	public static NumberCreator create(String numbers) {
		if (isChanngeDelimiter(numbers)) {
			return new DelimiterNumberCreator(numbers);
		}
		return new DefaultNumberCreator(numbers);
	}

	private static boolean isChanngeDelimiter(String numbers) {
		return numbers.startsWith(SIGNAL_OF_CHANGE_DELIMITER);
	}

	public boolean containNegativeNumber() {
		return !getNegativeNumbers().isEmpty();
	}

}
