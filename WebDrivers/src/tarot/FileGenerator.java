package tarot;

import org.openqa.selenium.WebElement;

public interface FileGenerator
{
	void generateDirectory();
	void generateTextFile(final WebElement element);
	String getFileName();
	String getPreviewLines(final String input); 
}
