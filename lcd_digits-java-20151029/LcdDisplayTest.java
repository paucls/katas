import org.junit.*;
import static org.junit.Assert.*;

public class LcdDisplayTest {

    LcdDisplay display;

    @Before
    public void setup() {
        display = new LcdDisplay();
    }

    @Test
    public void show_should_display_the_number_0() {
        String expected = " _ \n| |\n|_|";

        String actual = display.show(0);

        assertEquals(expected, actual);
    }

    @Test
    public void show_should_display_the_number_1() {
        String expected = "   \n  |\n  |";

        String actual = display.show(1);

        assertEquals(expected, actual);
    }

    @Test
    public void show_should_display_the_number_2() {
        String expected = " _ \n _|\n|_ ";

        String actual = display.show(2);

        assertEquals(expected, actual);
    }

    @Test
    public void show_should_display_a_two_digit_number() {
        String expected = " _ \n _|\n|_ \n   \n  |\n  |";

        String actual = display.show(21);

        assertEquals(expected, actual);
    }

    @Test
    public void show_should_display_a_three_digit_number() {
        String expected = " _ \n _|\n|_ \n   \n  |\n  |\n _ \n _|\n|_ ";

        String actual = display.show(212);

        assertEquals(expected, actual);
    }
}
