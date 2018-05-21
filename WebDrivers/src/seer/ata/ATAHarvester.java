package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractHarvester;
import seer.ata.ATAGetData;

public class ATAHarvester extends AbstractHarvester {
	public static final String ROOT_DIR = "ATATarot";
	public static final String FILE_EXT = "_ata.txt";
	
	private WebDriver _driver;
	private ATANavigator _nav;
	private ATAFrameSwitch _frameSwitch;
	private ATAGetData _getData;
	private List<WebElement> _navLinkElements;
	private String[] _navLinkTexts;
	
	public ATAHarvester(WebDriver driver) {
		super(ROOT_DIR, FILE_EXT);
		this._driver = driver;
		
		_nav         = new ATANavigator(_driver);
		_frameSwitch = new ATAFrameSwitch(_driver);
		_getData     = new ATAGetData(_driver);
		
		_navLinkElements = _getData.getAllNavigationLinkElements();
		_navLinkTexts    = _getData
			.getTextValuesFromLinkElements(_navLinkElements);
	}
	
	@Override
	public void harvest() throws Exception {
		for (int i = 0; i < _navLinkElements.size(); i++) {
			_frameSwitch.switchToNavigationFrame();
			linkText_ = _navLinkTexts[i];
			
			System.out.println("Harvesting data: " + linkText_ + " ...");
			By linkLocator = By.partialLinkText(linkText_);
			_nav.navigateToNextLink(linkLocator);
			
			paragraphs_ = _getData.getParagraphs();
			performHarvesterIO_();
		}
	}
}
