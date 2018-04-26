package tarot;

import java.io.File;

import org.openqa.selenium.WebElement;

public class ATAFileGenerator implements FileGenerator
{
	@Override
	public void generateDirectory()
	{
		File dir = new File("Tarot");
		dir.mkdir();
	}
	
	// helper.generateTxtFiles(String site)
			// checks if 'Tarot' dir exists, creates it if not
			// navigates to link[i]
			// switches to default, then data frame
			// scrapes data
			// checks the site, either "ata" or "trusted"
			// writes to file via 'cardstring_<site>.txt'
				// Make sure each ATA file starts w/ ATA: before the data
			// repeat
	@Override
	public void generateTextFile(WebElement element)
	{
		String fileName = _generateFileName(element);
		System.out.println(fileName);
	}
	
	private String _generateFileName(WebElement elem)
	{
		return elem.getText().replaceAll(" ", "_").toLowerCase() + "_ata.txt";
	}
}
