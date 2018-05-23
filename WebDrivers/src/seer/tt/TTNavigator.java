package seer.tt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractNavigator;
import seer.Navigator;

public class TTNavigator extends Navigator {
	public void navigateToNextLink(By linkLocator) {
		WebElement link = _getData.getPresentWebElement(linkLocator);
		navigateToLink(link);
	}
}
