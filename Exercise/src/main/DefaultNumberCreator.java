package main;

import java.util.Arrays;
import java.util.List;

public class DefaultNumberCreator extends NumberCreator {
	private static final String DEFAULT_DELIMITER = ",|\n";

	public DefaultNumberCreator(String numbers) {
		this.numbers = numbers;
	}

	@Override
	public List<String> getDelimiters() {
		return Arrays.asList(DEFAULT_DELIMITER);
	}

	@Override
	public String getNumberAfterDelimiter() {
		return numbers;
	}

}
