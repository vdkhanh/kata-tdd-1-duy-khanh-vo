package main;

public class DefaultNumberCreator extends NumberCreator {
	private static final String DEFAULT_DELIMITER = ",|\n";
	@Override
	public String getDelimiter(String numbers) {
		return DEFAULT_DELIMITER;
	}
	@Override
	public String getNumberWithOutdelimiter(String numbers) {
		// TODO Auto-generated method stub
		return null;
	}

}
