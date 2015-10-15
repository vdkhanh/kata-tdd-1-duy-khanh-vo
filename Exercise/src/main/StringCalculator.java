package main;

public class StringCalculator {

	private static final String NEW_LINE = "\n";
	private static final String SPLITTER = ",";
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
		String[] numbersArray = numbers.replaceAll(NEW_LINE, SPLITTER).split(SPLITTER);
		return numbersArray;
	}

}
