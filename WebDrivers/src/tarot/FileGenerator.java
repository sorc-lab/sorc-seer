package tarot;

import org.openqa.selenium.WebElement;

public interface FileGenerator
{
	void generateDirectory();
	void generateTextFile(WebElement element);
}
