package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtendDelimiterNumberCreator extends NumberCreator {

	private static final String EXTEND_DELIMITER_PATTERN = "\\[(.+?)\\]";

	public ExtendDelimiterNumberCreator(String numberWithExtendSpecifiedDelimiter) {
		numbers = numberWithExtendSpecifiedDelimiter;
	}

	@Override
	public String getDelimiter() {
		Pattern pattern = Pattern.compile(EXTEND_DELIMITER_PATTERN);
		Matcher matcher = pattern.matcher(numbers);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return "";
	}

	@Override
	public String getNumberAfterDelimiter() {
		int startIndex = numbers.indexOf("]\n") + "]\n".length();
		return numbers.substring(startIndex, numbers.length());
	}

}
