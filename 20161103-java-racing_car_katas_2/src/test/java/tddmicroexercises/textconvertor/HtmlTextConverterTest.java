package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTextConverterTest {

    @Test
    public void converter_is_constructed_for_a_file_path() {
        HtmlTextConverter converter = new HtmlTextConverter("file1.txt");

        assertEquals("file1.txt", converter.getFilename());
    }

}
