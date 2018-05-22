package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seer.GetHarvesterData;
import seer.Navigator;

public class ATANavigator extends Navigator {
	public static void navigateToNextLink(By linkLocator) {
		WebElement link = GetHarvesterData.getPresentWebElement(linkLocator);
		navigateToLink(link);
		ATAFrameSwitch.switchToDataFrame();
	}
}
