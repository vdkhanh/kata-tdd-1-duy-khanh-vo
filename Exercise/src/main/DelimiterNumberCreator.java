package main;

import java.util.Arrays;
import java.util.List;

public class DelimiterNumberCreator extends NumberCreator {

	private static final String BEGIN_OF_NUMBER = "\n";

	public DelimiterNumberCreator(String numbers) {
		this.numbers = numbers;
	}

	@Override
	public List<String> getDelimiters() {
		int delimiterIndex = USE_SPECIFIED_DELIMITER.length();
		return Arrays.asList(numbers.substring(delimiterIndex, delimiterIndex + 1));
	}

	@Override
	public String getNumberAfterDelimiter() {
		return numbers.substring(numbers.indexOf(BEGIN_OF_NUMBER) + 1);
	}
}
