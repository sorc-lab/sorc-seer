package seer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class HarvesterIO {
	public static final int LINE_LENGTH = 80;
	public static final String SPACE = " ";
	public static final String EMPTY_STRING = "";
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final String ROOT_DIR = System.getProperty("user.dir");
	
	private String _harvesterDataDir;
	private String _dataFileExt;
	
	// TODO: Remove all references to linkText/Para. from outside sources
	// TODO: Figure out how to do error checking for != null etc.
	private String _linkText;
	private String[] _paragraphs;
	
	// TODO: Construct w/ Builder Pattern
	public HarvesterIO(String harvesterDataDir, String dataFileExt,
			String linkText, String[] paragraphs)
	{
		this._harvesterDataDir = harvesterDataDir;
		this._dataFileExt = dataFileExt;
		this._linkText = linkText;
		this._paragraphs = paragraphs;
	}
	
	public void createDirectory(String directory) {
		File dir = new File(directory);
		dir.mkdir();
	}
	
	public void createTextFileFromLinkText(String linkText) throws Exception {
		File file = new File(_getTextFileAndPathFromLinkText(linkText));
		file.createNewFile();
	}
	
	private String _getTextFilePathFromLinkText(String linkText) {
		String filePath = ROOT_DIR + "/" + _harvesterDataDir + "/"
				+ _getDirNameFromLinkText(linkText);
		return filePath;
	}
	
	private String _getTextFileNameFromLinkText(String linkText) {
		return linkText.replaceAll(" ", "_").toLowerCase() + _dataFileExt;
	}
	
	private String _getTextFileAndPathFromLinkText(String linkText) {
		return _getTextFilePathFromLinkText(linkText) + "/"
				+ _getTextFileNameFromLinkText(linkText);
	}
	
	public void createDirectoryFromLinkText(String linkText) {
		String path = _harvesterDataDir+"/"+_getDirNameFromLinkText(linkText);
		File dir = new File(path);
		dir.mkdir();
	}
	
	private String _getDirNameFromLinkText(String linkText) {
		return linkText.replaceAll(" ", "_");
	}
	
	// TODO: Review and understand this code better
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
	
	// TODO: Depends on _fileName private var--most likely set in havest loop
	public void writeToFile(String linkText, String[] paragraphs)
			throws Exception
	{
		try {
			FileWriter fileWriter = new FileWriter(
					_getTextFileAndPathFromLinkText(linkText));
			
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
	
	public void performHarvesterIO(String linkText, String[] paragraphs)
			throws Exception
	{
		try {			
			createDirectoryFromLinkText(linkText);
			createTextFileFromLinkText(linkText);
			writeToFile(linkText, paragraphs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// TODO: Check back to see if getters are needed
	public String getHarvesterDataDir() { return _harvesterDataDir; }
	public String getHarvesterDataFileExt() { return _dataFileExt; }
	
	
	public static class Builder {
		private String _harvesterDataDir;
		private String _dataFileExt;
		private String _linkText;
		private String[] _paragraphs;
		
		public Builder setDir(String dir) {
			this._harvesterDataDir = dir;
			return this;
		}
		
		public Builder setFileExt(String fileExt) {
			this._dataFileExt = fileExt;
			return this;
		}
		
		public Builder setLinkText(String linkText) {
			this._linkText = linkText;
			return this;
		}
		
		public Builder setParagraphs(String[] paragraphs) {
			this._paragraphs = paragraphs;
			return this;
		}
		
		public HarvesterIO build() {
			HarvesterIO harvesterIO = new HarvesterIO(_harvesterDataDir,
					_dataFileExt, _linkText, _paragraphs);
			return harvesterIO;
		}
	}
}
