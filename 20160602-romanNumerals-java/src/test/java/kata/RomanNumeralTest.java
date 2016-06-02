package kata;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class RomanNumeralTest {

    @Test
    public void convert_1() {
        assertThat(RomanNumeral.convert(1), is("I"));
    }

    @Test
    public void corvert_3() {
        assertThat(RomanNumeral.convert(3), is("III"));
    }

    @Test
    public void corvert_4() {
        assertThat(RomanNumeral.convert(4), is("IV"));
    }

    @Test
    public void convert_5() {
        assertThat(RomanNumeral.convert(5), is("V"));
    }

    @Test
    public void convert_6() {
        assertThat(RomanNumeral.convert(6), is("VI"));
    }

    @Test
    public void convert_9() {
        assertThat(RomanNumeral.convert(9), is("IX"));
    }

    @Test
    public void convert_10() {
        assertThat(RomanNumeral.convert(10), is("X"));
    }

    @Test
    public void convert_13() {
        assertThat(RomanNumeral.convert(13), is("XIII"));
    }

}
