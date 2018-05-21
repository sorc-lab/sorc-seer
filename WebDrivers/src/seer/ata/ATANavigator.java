package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seer.ata.ATAGetData;
import seer.Navigator;

public class ATANavigator extends Navigator {
	private static ATAGetData _getData;
	
	public static void navigateToNextLink(By linkLocator) {
		_getData = new ATAGetData(); // TODO: Fix if ATAGetData is static util.
		
		WebElement link = _getData.getPresentWebElement(linkLocator);
		navigateToLink(link);
		ATAFrameSwitch.switchToDataFrame();
	}
}
