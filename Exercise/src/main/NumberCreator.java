package main;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberCreator {

	private static final String EMPTY = "";
	private static final String JOINER_CHARACTER = "|";
	private static final String SPECIAL_PATTERN_CHARACTERS = "*.+";
	protected static final String USE_SPECIFIED_DELIMITER = "//";
	private static final String USE_EXTEND_SPECIFIED_DELIMITER = "//[";
	private static final String ESCAPE_CHARACTER_PATTERN = "\\";
	protected String numbers;

	public abstract List<String> getDelimiters();

	public abstract String getNumberAfterDelimiter();

	public List<Integer> getNegativeNumbers() {
		List<Integer> numberAsList = getNumbersAsList();
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (Integer number : numberAsList) {
			if (number < 0) {
				negativeNumbers.add(number);
			}
		}
		return negativeNumbers;
	}

	public List<Integer> getNumbersAsList() {
		if (null == numbers || numbers.isEmpty()) {
			return new ArrayList<Integer>();
		}
		return extractNumberByDelimiters(this.getDelimiters(), this.getNumberAfterDelimiter());
	}

	private List<Integer> extractNumberByDelimiters(List<String> delimiters, String numberAfterDelimiter) {
		String combinationDelimiter = EMPTY;
		for (String delimiter : delimiters) {
			combinationDelimiter += JOINER_CHARACTER + delimiter;
		}
		combinationDelimiter = combinationDelimiter.replaceFirst("\\" + JOINER_CHARACTER, EMPTY);
		return extractNumberByDelimiter(combinationDelimiter, numberAfterDelimiter);
	}

	private List<Integer> extractNumberByDelimiter(String delimiter, String numberAfterDelimiter) {
		List<Integer> numbersAsList = new ArrayList<Integer>();
		for (String number : numberAfterDelimiter.split(getEscapedPattern(delimiter))) {
			try {
				numbersAsList.add(Integer.parseInt(number));
			} catch (Exception e) {
			}
		}
		return numbersAsList;
	}

	public static NumberCreator create(String numbers) {
		if (isUseExtendSpecifiedDelimiter(numbers)) {
			return new ExtendDelimiterNumberCreator(numbers);
		}
		if (isUseSpecifiedDelimiter(numbers)) {
			return new DelimiterNumberCreator(numbers);
		}
		return new DefaultNumberCreator(numbers);
	}

	private static boolean isUseExtendSpecifiedDelimiter(String numbers) {
		return numbers.startsWith(USE_EXTEND_SPECIFIED_DELIMITER);
	}

	private static boolean isUseSpecifiedDelimiter(String numbers) {
		return numbers.startsWith(USE_SPECIFIED_DELIMITER);
	}

	public boolean containNegativeNumber() {
		return !getNegativeNumbers().isEmpty();
	}

	private String getEscapedPattern(String pattern) {
		String escapedPattern = EMPTY;
		for (char c : pattern.toCharArray()) {
			if (SPECIAL_PATTERN_CHARACTERS.contains(String.valueOf(c))) {
				escapedPattern += ESCAPE_CHARACTER_PATTERN + String.valueOf(c);
			} else {
				escapedPattern += String.valueOf(c);
			}
		}
		return escapedPattern;
	}
}
