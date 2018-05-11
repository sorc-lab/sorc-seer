package seer.tt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractNavigator;

public class TTNavigator extends AbstractNavigator {
	private WebDriver _driver;
	private TTGetData _getData;

	public TTNavigator(WebDriver driver) {
		super(driver);
		this._driver = driver;
		_getData = new TTGetData(_driver);
	}

	@Override
	public void navigateToNextLink(By linkLocator) {
		WebElement link = _getData.getPresentWebElement(linkLocator);
		navigateToLink(link);
	}
}
