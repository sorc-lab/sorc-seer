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
		nav.switchToNavigationFrame();
		
		List<WebElement> navLinkElements = nav.getAllNavigationLinkElements();
		String[] navLinkTexts = getTextValuesFromLinkElements(navLinkElements);
		
		ATAFileGenerator fileGenerator = new ATAFileGenerator();
		fileGenerator.generateDirectory();
		
		Helper helper = new Helper();
		
		int navLinksCount = navLinkElements.size();
		for (int j = 0; j < navLinksCount; j++) {
			nav.switchToNavigationFrame();
			
			String linkText = navLinkTexts[j];
			System.out.println(
				"Harvesting data: " + linkText + " ..."
			);
			
			/** navigateToNextLink ========================================== */
			By linkLocator = By.partialLinkText(linkText);
			WebElement link = helper.getPresentWebElement(linkLocator);
			link.click();
			nav.switchToDataFrame();
			/** ============================================================= */
			
			
			HashMap<String, String[]> data = new HashMap<String, String[]>();
			String[] paragraphs = getParagraphs();
			data.put(linkText, paragraphs);
			
			/** writeToFiles (needs better name and needs to place into separate dirs */
			fileGenerator.generateTextFile(linkText);
			String fileName = fileGenerator.getFileName();
			
			FileWriter fileWriter = new FileWriter("Tarot/" + fileName);
			String newLine = System.getProperty("line.separator");
			fileWriter.write("ATA:" + newLine);
			
			for (int k = 0; k < paragraphs.length; k++) {
				String preview = fileGenerator.getPreviewLines(paragraphs[k]);
				fileWriter.write(preview + newLine);
				fileWriter.write(newLine);
			}
			
			fileWriter.close();
			/** ============================================================= */
		}	
	}
	
	public String[] getTextValuesFromLinkElements(List<WebElement> links)
	{
		int linksCount = links.size();
		String[] textValues = new String[linksCount];
		
		int i = 0;
		for (WebElement link : links) {
			textValues[i] = link.getText();
			i++;
		}
		
		return textValues;
	}
	
	// TODO: Add some error handling
	public String[] getParagraphs()
	{
		List<WebElement> elements = driver.findElements(By.tagName("p")); 
		int numberOfParagraphs = elements.size();
		String[] paragraphs = new String[numberOfParagraphs];
		
		int i = 0;
		for (WebElement element : elements) {
			paragraphs[i] = element.getText();
			i++;
		}
		
		return paragraphs;
	}
}
