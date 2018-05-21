package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seer.ata.ATAGetData;
import seer.Navigator;

public class ATANavigator extends Navigator {
	private static FrameSwitch _frameSwitch;
	private static ATAGetData _getData;
	
	public static void navigateToNextLink(By linkLocator) {
		WebElement link = _getData.getPresentWebElement(linkLocator);
		navigateToLink(link);
		_frameSwitch.switchToDataFrame();
	}
}
