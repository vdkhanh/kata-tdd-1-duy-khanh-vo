package main;

public class StringCalculator {

	private static final String SIGNAL_BEGIN_OF_NUMBER = "\n";
	private static final String SIGNAL_OF_CHANGE_DELIMITER = "//";
	private static final String DEFAULT_DELIMITER = ",|\n";
	private static final int ZERO = 0;

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return ZERO;
		}
		String[] numbersArray = getNumbersArray(numbers);
		return calculate(numbersArray);
	}

	private static int calculate(String[] numbersArray) {
		int sum = ZERO;
		for (String number : numbersArray) {
			sum += Integer.parseInt(number); // If it is not a number, parseInt
												// will throw an exception
		}
		return sum;
	}

	private static String[] getNumbersArray(String numbers) {
		String delimiter = getDelimiter(numbers);
		String numbersWithoutDelimiter = getNumberWithOutdelimiter(numbers);
		return numbersWithoutDelimiter.split(delimiter);
	}

	private static String getNumberWithOutdelimiter(String numbers) {
		if (isChanngeDelimiter(numbers)) {
			return numbers.substring(numbers.indexOf(SIGNAL_BEGIN_OF_NUMBER) + 1);
		}
		return numbers;
	}

	private static String getDelimiter(String numbers) {
		if (isChanngeDelimiter(numbers)) {
			int delimiterIndex = SIGNAL_OF_CHANGE_DELIMITER.length();
			return numbers.substring(delimiterIndex, delimiterIndex + 1);
		}
		return DEFAULT_DELIMITER;
	}

	private static boolean isChanngeDelimiter(String numbers) {
		return numbers.startsWith(SIGNAL_OF_CHANGE_DELIMITER);
	}

}
