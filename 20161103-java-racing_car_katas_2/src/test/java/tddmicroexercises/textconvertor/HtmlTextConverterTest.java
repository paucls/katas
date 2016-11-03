package tddmicroexercises.textconvertor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class HtmlTextConverterTest {

    BufferedReader bufferReaderMock;

    @Before
    public void setup() {
        bufferReaderMock = Mockito.mock(BufferedReader.class);
    }

    @Test
    public void converter_is_constructed_for_a_file_path() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file.txt", bufferReaderMock);

        assertEquals("file.txt", converter.getFilename());
    }

    @Test
    public void converter_adds_br_element_at_the_end_of_each_line() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file.txt", bufferReaderMock);

        when(bufferReaderMock.readLine())
                .thenReturn("Hello")
                .thenReturn("World")
                .thenReturn(null);

        String htmlCode = converter.convertToHtml();

        assertThat(htmlCode, is("Hello<br />World<br />"));
    }

    @Test
    public void converter_scapes_special_characters() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file.txt", bufferReaderMock);

        when(bufferReaderMock.readLine())
                .thenReturn("Hello 'World'")
                .thenReturn(null);

        String htmlCode = converter.convertToHtml();

        assertThat(htmlCode, is("Hello &quot;World&quot;<br />"));
    }

}
