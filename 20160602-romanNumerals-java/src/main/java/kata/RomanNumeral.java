package kata;

public class RomanNumeral {

	public static final String SYMBOL_FOR_1 = "I";
	public static final String SYMBOL_FOR_5 = "V";
	public static final String SYMBOL_FOR_10 = "X";

	public static String convert(int number) {

		StringBuffer result = new StringBuffer();

		int mod = number % 5;

		if (mod == 4) {
			result.append(SYMBOL_FOR_1);
			number++;
			mod = number % 5;
		}

		boolean isDivisibleBy10 = number / 10 == 1;
		boolean isDivisibleBy5 = number / 5 == 1;

		if (isDivisibleBy10) {
			appendSymbol(result, SYMBOL_FOR_10);
		} else if (isDivisibleBy5) {
			appendSymbol(result, SYMBOL_FOR_5);
		}

		for (int i = 0; i < mod; i++) {
			appendSymbol(result, SYMBOL_FOR_1);
		}

		return result.toString();
	}

	private static void appendSymbol(StringBuffer buffer, String symbol) {
		buffer.append(symbol);
	}

}
