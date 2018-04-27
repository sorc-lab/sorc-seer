package tarot;

public interface FileGenerator
{
	void generateDirectory();
	void generateTextFile(final String text);
	String getFileName();
	String getPreviewLines(final String input);
	void writeToFile(String linkText, String[] paragraphs) throws Exception;
}
