package org.sammancoaching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.sammancoaching.StringEscapeUtils.escapeHtml;

public class HtmlConverter {

    public String convertToHtml(String filename) throws IOException {
        FileReader in = new FileReader(filename);
        BufferedReader reader = new BufferedReader(in);
        return convertToHtml(reader);
    }

    protected String convertToHtml(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        var html = new StringBuilder("<html>");
        while (line != null) {
            html.append("<p>");
            line = line.trim();
            html.append(escapeHtml(line));
            html.append("</p>");
            line = reader.readLine();
        }
        html.append("</html>");
        return html.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java HtmlConverter <filename>");
            System.exit(1);
        }
        HtmlConverter converter = new HtmlConverter();
        System.out.print(converter.convertToHtml(args[0]));
    }
}
