package main;

public class StringCalculator {

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String[] numbersArray = numbers.split(",");
		int sum = 0;
		for (String number : numbersArray) {
			sum += Integer.parseInt(number); // If it is not a number, parseInt
												// will throw an exception
		}
		return sum;
	}

}
