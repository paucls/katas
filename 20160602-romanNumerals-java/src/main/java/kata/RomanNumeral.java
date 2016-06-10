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
		if (number == 0) {
			return "";
		}

		int length = String.valueOf(number).length();
		int base = (int) Math.pow(10, length - 1);

		if (number % (5 * base) >= (4 * base)) {
			return NUMERALS.get(base) + convert(number + base);
		}

		if (number >= (5 * base)) {
			return NUMERALS.get(5 * base) + convert(number - (5 * base));
		}

		return NUMERALS.get(base) + convert(number - base);
	}

}
