package kata;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

	private static final Map NUMERALS = new HashMap() {
		{
			put(1, "I");
			put(5, "V");
			put(10, "X");
			put(50, "L");
			put(100, "C");
			put(500, "D");
			put(1000, "M");
		}
	};

	public static String convert(int number) {
		if (number >= 1000) {
			return NUMERALS.get(1000) + convert(number - 1000);
		} else if (number >= 100) {
			return handleThousands(number);
		} else if (number >= 10) {
			return handleHundreds(number);
		}
		return handleTens(number);
	}

	private static String handleThousands(int number) {
		if (number >= 1000 - 100) {
			return NUMERALS.get(100) + convert(number + 100);
		}

		if (number >= 500) {
			return NUMERALS.get(500) + convert(number - 500);
		}

		if (number >= 500 - 100) {
			return NUMERALS.get(100) + convert(number + 100);
		}

		if (number >= 100) {
			return NUMERALS.get(100) + convert(number - 100);
		}

		return "";
	}

	private static String handleHundreds(int number) {
		if (number >= 100 - 10) {
			return NUMERALS.get(10) + convert(number + 10);
		}

		if (number >= 50) {
			return NUMERALS.get(50) + convert(number - 50);
		}

		if (number >= 50 - 10) {
			return NUMERALS.get(10) + convert(number + 10);
		}

		if (number >= 10) {
			return NUMERALS.get(10) + convert(number - 10);
		}

		return "";
	}

	private static String handleTens(int number) {
		if (number >= 10 - 1) {
			return NUMERALS.get(1) + convert(number + 1);
		}

		if (number >= 5) {
			return NUMERALS.get(5) + convert(number - 5);
		}

		if (number >= 5 - 1) {
			return NUMERALS.get(1) + convert(number + 1);
		}

		if (number >= 1) {
			return NUMERALS.get(1) + convert(number - 1);
		}

		return "";
	}

}
