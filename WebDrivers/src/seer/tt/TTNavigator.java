package seer.tt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seer.Navigator;

public class TTNavigator extends Navigator {
	public static void navigateToNextLink(By linkLocator) {
		WebElement link = TTGetData.getPresentWebElement(linkLocator);
		navigateToLink(link);
	}
}
