import java.util.*;

public class LcdDisplay {
    private static Map<Integer, String> digits = new HashMap<Integer, String>();

    public LcdDisplay() {
        digits.put(0, " _ \n| |\n|_|");
        digits.put(1, "   \n  |\n  |");
        digits.put(2, " _ \n _|\n|_ ");
    }

    public String show(int value) {
        if (value <= 9)
            return digits.get(value);

        int decena = value / 10;
        int resto = value % 10;

        return show(decena) + "\n" + digits.get(resto);
    }

}
