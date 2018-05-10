package seer.ata;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractHarvester;
import seer.ata.ATAGetData;

public class ATAHarvester extends AbstractHarvester {
	private WebDriver _driver;
	private ATANavigator _nav;
	private FrameSwitch _frameSwitch;
	private ATAGetData _getData;
	private List<WebElement> _navLinkElements;
	private String[] _navLinkTexts;
	private HashMap<String, String[]> _data;
	
	public ATAHarvester(WebDriver driver) {
		super("ATATarot", "_ata.txt");
		this._driver = driver;
		_nav         = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_getData     = new ATAGetData(_driver);
		_navLinkElements = _getData.getAllNavigationLinkElements();
		_navLinkTexts    = _getData
			.getTextValuesFromLinkElements(_navLinkElements);
		_data = new HashMap<String, String[]>();
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
			_data.put(linkText_, paragraphs_);
			performHarvesterIO_();
		}
	}
}
