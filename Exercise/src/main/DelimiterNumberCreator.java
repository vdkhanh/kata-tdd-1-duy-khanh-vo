package main;

public class DelimiterNumberCreator extends NumberCreator {

	private static final String BEGIN_OF_NUMBER = "\n";

	public DelimiterNumberCreator(String numbers) {
		this.numbers = numbers;
	}

	@Override
	public String getDelimiter() {
		int delimiterIndex = USE_SPECIFIED_DELIMITER.length();
		return numbers.substring(delimiterIndex, delimiterIndex + 1);
	}

	@Override
	public String getNumberAfterDelimiter() {
		return numbers.substring(numbers.indexOf(BEGIN_OF_NUMBER) + 1);
	}
}
