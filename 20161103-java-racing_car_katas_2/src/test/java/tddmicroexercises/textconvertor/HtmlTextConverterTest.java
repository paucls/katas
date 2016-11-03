package tddmicroexercises.textconvertor;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HtmlTextConverterTest {

    @Test
    public void converter_is_constructed_for_a_file_path() {
        HtmlTextConverter converter = new HtmlTextConverter("file1.txt");

        assertEquals("file1.txt", converter.getFilename());
    }

    @Test
    public void converter_adds_br_element_at_the_end_of_each_line() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("./file1.txt");

        String htmlCode = converter.convertToHtml();

        assertThat(htmlCode, is("Hello<br />World<br />"));
    }

    @Test
    public void converter_scapes_special_characters() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("./file2.txt");

        String htmlCode = converter.convertToHtml();

        assertThat(htmlCode, is("Hello &quot;World&quot;<br />"));
    }

}
