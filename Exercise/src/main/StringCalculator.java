package main;

public class StringCalculator {

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
		String delimiter = ",|\n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = "//".length();
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
		}
		return numbersWithoutDelimiter.split(delimiter);
	}

}
