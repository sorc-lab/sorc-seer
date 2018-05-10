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
import seer.ata.ATAGetData;

// TODO: Implement via Scraper interface
public class ATAScraper {
	private WebDriver _driver;
	private Navigator _nav;
	private FrameSwitch _frameSwitch;
	private FileGenerator _fileGen;
	private ATAGetData _getData;
	
	public ATAScraper(WebDriver driver) {
		this._driver = driver;
		_nav = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_fileGen = new ATAFileGenerator();
		_getData = new ATAGetData(_driver);
	}
	
	public void scrape() throws Exception {
		List<WebElement>navLinkElements=_getData.getAllNavigationLinkElements();
		String[] navLinkTexts = _getData.getTextValuesFromLinkElements(
			navLinkElements
		);
		for (int i = 0; i < navLinkElements.size(); i++) {
			_frameSwitch.switchToNavigationFrame();
			
			String linkText = navLinkTexts[i];
			System.out.println(
				"Harvesting data: " + linkText + " ..."
			);
			
			By linkLocator = By.partialLinkText(linkText);
			_nav.navigateToNextLink(linkLocator);
			
			Map<String, String[]> data = new HashMap<String, String[]>();
			String[] paragraphs = _getData.getParagraphs();
			data.put(linkText, paragraphs);
			insert(linkText, paragraphs);
		}	
	}
	
	// TODO: Fix and move to FileGenerator
	public void insert(String linkText, String[] paragraphs) throws Exception {
		try {
			_fileGen.writeToFile(linkText, paragraphs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
