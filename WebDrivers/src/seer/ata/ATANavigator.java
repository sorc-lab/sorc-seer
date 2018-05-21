package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.ata.ATAGetData;
import seer.AbstractNavigator;
import seer.PhantomDriver;

public class ATANavigator extends AbstractNavigator {
	private FrameSwitch _frameSwitch;
	private ATAGetData _getData;
	
	@Override
	public void navigateToNextLink(By linkLocator) {
		WebElement link = _getData.getPresentWebElement(linkLocator);
		navigateToLink(link);
		_frameSwitch.switchToDataFrame();
	}
}
