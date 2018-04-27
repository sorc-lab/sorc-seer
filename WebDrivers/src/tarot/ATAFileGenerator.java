package tarot;

import java.io.File;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class ATAFileGenerator implements FileGenerator
{
	private static final int LINE_LENGTH = 80;
	private static final String SPACE = " ";
	private static final String EMPTY_STRING = "";
	
	private String _fileName;
	
	@Override
	public void generateDirectory()
	{
		File dir = new File("Tarot");
		dir.mkdir();
	}
	
	@Override
	public void generateTextFile(final String text)
	{
		String fileName = _generateFileName(text);
		this._fileName = fileName;
	}
	
	@Override
	public String getFileName()
	{
		if (_fileName == null) { return ""; }
		return _fileName;
	}
	
	private String _generateFileName(final String text)
	{
		return text.replaceAll(" ", "_").toLowerCase() + "_ata.txt";
	}
	
	@Override
	public String getPreviewLines(final String input) 
	{
	    final StringTokenizer token = new StringTokenizer(input, SPACE);
	    final StringBuilder output = new StringBuilder(input.length());

	    int lineLen = 0;

	    while (token.hasMoreTokens()) {
	        final String word = token.nextToken() + SPACE;

	        if (lineLen + word.length() - 1 > LINE_LENGTH) {
	            output.append(System.lineSeparator());
	            lineLen = 0;
	        }

	        output.append(word);

	        if (word.contains(System.lineSeparator())) 
	            lineLen = word.replaceAll("\\s+", EMPTY_STRING).length(); //$NON-NLS-1$
	        else
	            lineLen += word.length();
	    }

	    return output.toString();
	}	
	
	// TODO: ADD TO INTERFACE
	public void writeToFile(String linkText, String[] paragraphs)
	throws Exception
	{
		generateTextFile(linkText);
		String fileName = getFileName();
		
		linkText = linkText.replaceAll(" ", "_");
		File dir = new File("Tarot/" + linkText);
		dir.mkdir();
		
		FileWriter fileWriter = new FileWriter(
			"Tarot/" + linkText + "/" + fileName
		);
		String newLine = System.getProperty("line.separator");
		fileWriter.write("ATA:" + newLine);
		
		for (int i = 0; i < paragraphs.length; i++) {
			String preview = getPreviewLines(paragraphs[i]);
			fileWriter.write(preview + newLine);
			fileWriter.write(newLine);
		}
		
		fileWriter.close();
	}
}
