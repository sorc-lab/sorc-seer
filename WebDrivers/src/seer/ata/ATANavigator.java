package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.ata.ATAGetData;
import seer.Navigator;

// TODO: Make this extend from an AbstractClass
public class ATANavigator implements Navigator {
	public static  String HOME="http://www.ata-tarot.com/resource/cards/index.html";
		
	private WebDriver _driver;
	private FrameSwitch _frameSwitch;
	private ATAGetData _getData;
	
	public ATANavigator(WebDriver driver) {
		this._driver = driver;
		_frameSwitch = new FrameSwitch(_driver);
		_getData = new ATAGetData(_driver);
	}
	
	@Override
	public void navigateToHomepage() { _driver.get(HOME); }
	
	@Override
	public void navigateToLink(WebElement link) { link.click(); }
	
	@Override
	public void navigateToNextLink(By linkLocator) {
		WebElement link = _getData.getPresentWebElement(linkLocator);
		navigateToLink(link);
		_frameSwitch.switchToDataFrame();
	}
}
