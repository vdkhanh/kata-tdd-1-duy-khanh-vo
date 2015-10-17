package main;

public class DefaultNumberCreator extends NumberCreator {
	private static final String DEFAULT_DELIMITER = ",|\n";

	public DefaultNumberCreator(String numbers) {
		this.numbers = numbers;
	}

	@Override
	public String getDelimiter() {
		return DEFAULT_DELIMITER;
	}

	@Override
	public String getNumberAfterDelimiter() {
		return numbers;
	}

}
