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
			return handleNumberForBase(number, 1000);
		}
		if (number >= 100) {
			return handleNumberForBase(number, 100);
		}
		if (number >= 10) {
			return handleNumberForBase(number, 10);
		}
		return handleNumberForBase(number, 1);
	}

	private static String handleNumberForBase(int number, int base) {
		if (number % (5 * base) >= (4 * base)) {
			return NUMERALS.get(1 * base) + convert(number + (1 * base));
		}

		if (number >= (5 * base)) {
			return NUMERALS.get(5 * base) + convert(number - (5 * base));
		}

		if (number >= (1 * base)) {
			return NUMERALS.get(1 * base) + convert(number - (1 * base));
		}

		return "";
	}

}
