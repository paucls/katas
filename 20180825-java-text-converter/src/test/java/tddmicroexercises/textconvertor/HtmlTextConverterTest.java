package tddmicroexercises.textconvertor;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HtmlTextConverterTest {
    @Test
    public void should_have_a_filename() {
        HtmlTextConverter converter = new HtmlTextConverter("/a-file");
        assertThat(converter.getFilename(), is("/a-file"));
    }
}
