package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtendDelimiterNumberCreator extends NumberCreator {

	public ExtendDelimiterNumberCreator(String numberWithExtendSpecifiedDelimiter) {
		numbers = numberWithExtendSpecifiedDelimiter;
	}

	@Override
	public String getDelimiter() {
		Pattern pattern = Pattern.compile("\\[(.+?)\\]");
		Matcher matcher = pattern.matcher(numbers);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return "";
	}

	@Override
	public String getNumberAfterDelimiter() {
		// TODO Auto-generated method stub
		return null;
	}

}
