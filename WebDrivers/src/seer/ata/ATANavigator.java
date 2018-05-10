package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.ata.ATAGetData;
import seer.AbstractNavigator;

public class ATANavigator extends AbstractNavigator {
	private WebDriver _driver;
	private FrameSwitch _frameSwitch;
	private ATAGetData _getData;
	
	public ATANavigator(WebDriver driver) {
		super(driver);
		this._driver = driver;
		_frameSwitch = new FrameSwitch(_driver);
		_getData = new ATAGetData(_driver);
	}
	
	@Override
	public void navigateToNextLink(By linkLocator) {
		WebElement link = _getData.getPresentWebElement(linkLocator);
		navigateToLink(link);
		_frameSwitch.switchToDataFrame();
	}
}
