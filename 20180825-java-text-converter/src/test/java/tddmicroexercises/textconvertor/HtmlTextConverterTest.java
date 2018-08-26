package tddmicroexercises.textconvertor;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HtmlTextConverterTest {
    @Test
    public void should_have_a_filename() {
        HtmlTextConverter converter = new HtmlTextConverter("/a-file");

        assertThat(converter.getFilename(), is("/a-file"));
    }

    @Test
    public void should_convert_empty_file_as_empty_string() throws IOException {
        BufferedReader bufferedReaderStub = mock(BufferedReader.class);
        HtmlTextConverter converter = new TestingHtmlTextConverter("filepath", bufferedReaderStub);

        assertThat(converter.convertToHtml(), is(""));
    }

    @Test
    public void should_insert_a_html_br_after_each_line() throws IOException {
        BufferedReader bufferedReaderStub = mock(BufferedReader.class);
        HtmlTextConverter converter = new TestingHtmlTextConverter("/a-file", bufferedReaderStub);

        when(bufferedReaderStub.readLine())
                .thenReturn("some text")
                .thenReturn(null);

        assertThat(converter.convertToHtml(), is("some text<br />"));
    }

    @Test
    public void should_escape_html_characters() throws IOException {
        BufferedReader bufferedReaderStub = mock(BufferedReader.class);
        HtmlTextConverter converter = new TestingHtmlTextConverter("/a-file", bufferedReaderStub);

        when(bufferedReaderStub.readLine())
                .thenReturn("text & text")
                .thenReturn(null);

        assertThat(converter.convertToHtml(), is("text &amp; text<br />"));
    }
}

class TestingHtmlTextConverter extends HtmlTextConverter {

    private BufferedReader bufferedReaderStub;

    TestingHtmlTextConverter(String fullFilenameWithPath, BufferedReader bufferedReaderStub) {
        super(fullFilenameWithPath);
        this.bufferedReaderStub = bufferedReaderStub;
    }

    @Override
    BufferedReader getReader() {
        return bufferedReaderStub;
    }
}