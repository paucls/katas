package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter
{
    private String fullFilenameWithPath;
	private BufferedReader reader;

    public HtmlTextConverter(String fullFilenameWithPath) throws IOException
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
		this.reader = new BufferedReader(new FileReader(fullFilenameWithPath));
    }

	public HtmlTextConverter(String fullFilenameWithPath, BufferedReader reader) {
        this.fullFilenameWithPath = fullFilenameWithPath;
		this.reader = reader;
	}

	public String convertToHtml() throws IOException{

	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}
