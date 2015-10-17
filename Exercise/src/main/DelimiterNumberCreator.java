package main;

public class DelimiterNumberCreator extends NumberCreator {

	private static final String SIGNAL_BEGIN_OF_NUMBER = "\n";

	public DelimiterNumberCreator(String numbers) {
		this.numbers = numbers;
	}

	@Override
	public String getDelimiter() {
		int delimiterIndex = SIGNAL_OF_CHANGE_DELIMITER.length();
		return numbers.substring(delimiterIndex, delimiterIndex + 1);
	}

	@Override
	public String getNumberAfterDelimiter() {
		return numbers.substring(numbers.indexOf(SIGNAL_BEGIN_OF_NUMBER) + 1);
	}
}
