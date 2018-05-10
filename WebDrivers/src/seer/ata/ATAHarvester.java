package seer.ata;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.HarvesterIO;
import seer.ata.ATAGetData;

// TODO: Implement via Scraper interface
public class ATAHarvester {
	private WebDriver _driver;
	private ATANavigator _nav;
	private FrameSwitch _frameSwitch;
	private HarvesterIO _io;
	private ATAGetData _getData;
	private List<WebElement> _navLinkElements;
	private String[] _navLinkTexts;
	private String _linkText;
	private String[] _paragraphs;
	private HashMap<String, String[]> _data;
	
	public ATAHarvester(WebDriver driver) {
		this._driver = driver;
		_nav         = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_io          = new HarvesterIO("ATATarot", "_ata.txt");
		_getData     = new ATAGetData(_driver);
		_navLinkElements = _getData.getAllNavigationLinkElements();
		_navLinkTexts    = _getData
			.getTextValuesFromLinkElements(_navLinkElements);
		_data = new HashMap<String, String[]>();
	}
	
	public void harvest() throws Exception {
		for (int i = 0; i < _navLinkElements.size(); i++) {
			_frameSwitch.switchToNavigationFrame();
			_linkText = _navLinkTexts[i];
			
			System.out.println("Harvesting data: " + _linkText + " ...");
			By linkLocator = By.partialLinkText(_linkText);
			_nav.navigateToNextLink(linkLocator);
			
			_paragraphs = _getData.getParagraphs();
			_data.put(_linkText, _paragraphs);
			_performHarvesterIO();
		}
	}
	
	private void _performHarvesterIO() throws Exception {
		try {
			_io.createDirectoryFromLinkText(_linkText);
			_io.createTextFileFromLinkText(_linkText);
			_io.writeToFile(_linkText, _paragraphs);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
