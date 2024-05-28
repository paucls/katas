package org.sammancoaching;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlConverterTest {

    private final HtmlConverter htmlConverter = new HtmlConverter();

    @Test
    public void convertToHtml_UsesValidHtmlTags() throws IOException {
        StringReader stringReader = new StringReader("");
        BufferedReader bufferedReader = new BufferedReader(stringReader);

        String html = htmlConverter.convertToHtml(bufferedReader);

        assertEquals("<html></html>", html);
    }

    @Test
    public void convertToHtml_UsesValidParagraphTags() throws IOException {
        StringReader stringReader = new StringReader("line 1");
        BufferedReader bufferedReader = new BufferedReader(stringReader);

        String html = htmlConverter.convertToHtml(bufferedReader);

        assertEquals("<html><p>line 1</p></html>", html);
    }
}


class StubTwoLineReader extends Reader {
    private int counter = -1;

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        counter++;
        var charCount = 0;
        if (counter == 0) {
            var text = "first line\n";
            charCount = fillBuffer(cbuf, off, len, text);
        }
        else if (counter == 1){
            var text = "  second line  \n";
            charCount = fillBuffer(cbuf, off, len, text);
        }
        else if (counter >= 2){
            return -1;
        }
        return charCount;
    }

    private static int fillBuffer(char[] cbuf, int off, int len, String text) {
        var charCount = 0;
        for (int i = off; i < off + len; i++) {
            if (text.length() <= i)
                break;
            cbuf[i] = text.charAt(i);
            charCount++;
        }
        return charCount;
    }

    @Override
    public void close() throws IOException {
    }
}

class StubEmptyReader extends Reader {

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return -1;
    }

    @Override
    public void close() throws IOException {
    }
}

