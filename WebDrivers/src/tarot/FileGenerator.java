package tarot;

public interface FileGenerator
{
	void generateDirectory();
	void generateTextFile(final String text);
	String getFileName();
	String getPreviewLines(final String input); 
}
