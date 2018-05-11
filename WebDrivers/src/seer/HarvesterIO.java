package seer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class HarvesterIO {
	private static final int LINE_LENGTH = 80;
	private static final String SPACE = " ";
	private static final String EMPTY_STRING = "";
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private String _rootDir;
	private String _fileExt;
	private String _fileName;
	private String _dir;
	
	public HarvesterIO(String rootDir, String fileExt) {
		this._rootDir = rootDir;
		this._fileExt = fileExt;
	}
	
	public void createDirectory(String directory) {
		this._dir = directory;
		File dir = new File(_dir);
		dir.mkdir();
	}
	
	public void createTextFileFromLinkText(String linkText) throws Exception {
		String fileName = _dir + "/" + linkText.replaceAll(" ", "_")
			.toLowerCase() + _fileExt;
		this._fileName = fileName;
		File file = new File(_fileName);
		file.createNewFile();
	}
	
	public void createDirectoryFromLinkText(String linkText) {
		String formatLinkText = linkText.replaceAll(" ", "_");
		String path = _rootDir + "/" + formatLinkText;
		File dir = new File(path);
		_dir = path;
		dir.mkdir();
	}
	
	public String getPreviewLines(String input) {
	    StringTokenizer token = new StringTokenizer(input, SPACE);
	    StringBuilder output = new StringBuilder(input.length());

	    int lineLen = 0;

	    while (token.hasMoreTokens()) {
	        String word = token.nextToken() + SPACE;

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
	
	public void writeToFile(String linkText, String[] paragraphs)
	throws Exception
	{
		try {
			FileWriter fileWriter = new FileWriter(_fileName);
			for (int i = 0; i < paragraphs.length; i++) {
				String preview = getPreviewLines(paragraphs[i]);
				fileWriter.write(preview + NEW_LINE);
				fileWriter.write(NEW_LINE);
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
