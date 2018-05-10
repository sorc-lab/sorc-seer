package seer.ata;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.FileGenerator;
import seer.Navigator;

public class ATAScraper {
	private WebDriver _driver;
	private Navigator _nav;
	private FrameSwitch _frameSwitch;
	private FileGenerator _fileGen;
	
	public ATAScraper(WebDriver driver) {
		this._driver = driver;
		_nav = new ATANavigator(this._driver);
		_frameSwitch = new FrameSwitch(_driver);
		_fileGen = new ATAFileGenerator();
	}
	
	public void scrape() throws Exception {
		List<WebElement> navLinkElements = _nav.getAllNavigationLinkElements();
		String[] navLinkTexts = getTextValuesFromLinkElements(navLinkElements);
		
		// this is the only part that should be in this function
		for (int i = 0; i < navLinkElements.size(); i++) {
			_frameSwitch.switchToNavigationFrame();
			
			String linkText = navLinkTexts[i];
			System.out.println(
				"Harvesting data: " + linkText + " ..."
			);
			
			By linkLocator = By.partialLinkText(linkText);
			_nav.navigateToNextLink(linkLocator);
			
			Map<String, String[]> data = new HashMap<String, String[]>();
			String[] paragraphs = getParagraphs();
			data.put(linkText, paragraphs);
			insert(linkText, paragraphs);
		}	
	}
	
	public void insert(String linkText, String[] paragraphs) throws Exception {
		try {
			_fileGen.writeToFile(linkText, paragraphs);
		} catch (IOException e) {
			e.printStackTrace();
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
