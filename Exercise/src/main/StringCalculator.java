package main;

public class StringCalculator {

	private static final String SPLITTER = ",";
	private static final int MAX_NUMBER_OF_INPUT = 2;
	private static final int ZERO = 0;

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return ZERO;
		}
		String[] numbersArray = numbers.split(SPLITTER);
		if(numbersArray.length > MAX_NUMBER_OF_INPUT){
			throw new RuntimeException();
		}
		int sum = ZERO;
		for (String number : numbersArray) {
			sum += Integer.parseInt(number); // If it is not a number, parseInt
												// will throw an exception
		}
		return sum;
	}

}
