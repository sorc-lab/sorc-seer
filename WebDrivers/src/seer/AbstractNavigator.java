package seer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractNavigator {
	private WebDriver _driver;
	
	public AbstractNavigator(WebDriver driver) { this._driver = driver; }
	public void navigateToHomepage(String url) { _driver.get(url); }
	public void navigateToLink(WebElement link) { link.click(); }
	abstract public void navigateToNextLink(By linkLocator);
}
