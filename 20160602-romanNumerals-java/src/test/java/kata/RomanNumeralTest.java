package kata;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class RomanNumeralTest {

    @Test
    public void convert_1() {
        assertThat(RomanNumeral.convert(1), is("I"));
    }

}
