package tarot;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ATADataHarvester extends PhantomDriver
{
	public void harvest() throws Exception
	{
		ATANavigator nav = new ATANavigator(); 
		nav.navigateHomepage();
		nav.switchToDefaultFrame();
		nav.switchToNavigationFrame();
		
		List<WebElement> navigationLinks = nav.getAllNavigationLinks();
		int navigationLinksCount = navigationLinks.size();
		String[] navigationLinkTexts = new String[navigationLinksCount];
		
		int i = 0;
		for (WebElement link : navigationLinks) {
			navigationLinkTexts[i] = link.getText();
			i++;
		}
		
		ATAFileGenerator fileGenerator = new ATAFileGenerator();
		fileGenerator.generateDirectory();
		Helper helper = new Helper();
		
		for (int j = 0; j < navigationLinksCount; j++) {
			nav.switchToDefaultFrame();
			nav.switchToNavigationFrame();
			
			String linkText = navigationLinkTexts[j];
			System.out.println(
				"Harvesting data: " + linkText + " ..."
			);
			
			By linkLocator = By.partialLinkText(linkText);
			WebElement link = helper.getPresentWebElement(linkLocator);
			link.click();

			nav.switchToDefaultFrame();
			nav.switchToDataFrame();
			HashMap<String, String[]> data = new HashMap<String, String[]>();
			
			List<WebElement> elements = driver.findElements(By.tagName("p")); 
			int numberOfParagraphs = elements.size();
			String[] paragraphs = new String[numberOfParagraphs];
			
			i = 0;
			for (WebElement element : elements) {
				paragraphs[i] = element.getText();
				i++;
			}
			
			data.put(linkText, paragraphs);
			
			fileGenerator.generateTextFile(linkText);
			String fileName = fileGenerator.getFileName();
			
			FileWriter fileWriter = new FileWriter(fileName);
			String newLine = System.getProperty("line.separator");
			fileWriter.write("ATA:" + newLine);
			
			for (i = 0; i < paragraphs.length; i++) {
				String preview = fileGenerator.getPreviewLines(paragraphs[i]);
				fileWriter.write(preview + newLine);
				fileWriter.write(newLine);
			}
			
			fileWriter.close();		
		}
	}
}
