package seer.ata;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ATAScraper {
	private WebDriver _driver;
	
	public ATAScraper(WebDriver driver) { this._driver = driver; }
	
	public void scrape() throws Exception {
		ATANavigator nav = new ATANavigator(_driver);
		nav.navigateHomepage();
		nav.switchToNavigationFrame();
		
		List<WebElement> navLinkElements = nav.getAllNavigationLinkElements();
		String[] navLinkTexts = getTextValuesFromLinkElements(navLinkElements);
		
		ATAFileGenerator fileGenerator = new ATAFileGenerator();
		fileGenerator.generateDirectory();
		
		for (int i = 0; i < navLinkElements.size(); i++) {
			nav.switchToNavigationFrame();
			
			String linkText = navLinkTexts[i];
			System.out.println(
				"Harvesting data: " + linkText + " ..."
			);
			
			By linkLocator = By.partialLinkText(linkText);
			nav.navigateToNextLink(linkLocator);
			
			HashMap<String, String[]> data = new HashMap<String, String[]>();
			String[] paragraphs = getParagraphs();
			data.put(linkText, paragraphs);
			
			try {
				fileGenerator.writeToFile(linkText, paragraphs);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public String[] getTextValuesFromLinkElements(List<WebElement> links) {
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
	public String[] getParagraphs() {
		List<WebElement> elements = _driver.findElements(By.tagName("p")); 
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
