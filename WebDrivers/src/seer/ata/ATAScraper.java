package seer.ata;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.ScraperIO;
import seer.ata.ATAGetData;

// TODO: Implement via Scraper interface
public class ATAScraper {
	private WebDriver _driver;
	private ATANavigator _nav;
	private FrameSwitch _frameSwitch;
	private ScraperIO _io;
	private ATAGetData _getData;
	
	public ATAScraper(WebDriver driver) {
		this._driver = driver;
		_nav = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_io = new ScraperIO("ATATarot", "_ata.txt");
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
			
			HashMap<String, String[]> data = new HashMap<String, String[]>();
			String[] paragraphs = _getData.getParagraphs();
			data.put(linkText, paragraphs);
			
			_io.createDirectoryFromLinkText(linkText);
			_io.createTextFileFromLinkText(linkText);
			_io.writeToFile(linkText, paragraphs);
		}	
	}
}
