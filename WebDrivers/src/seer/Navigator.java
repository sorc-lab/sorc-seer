package seer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navigator {
	private static WebDriver _driver = PhantomDriver.getPhantomDriver();
	
	public static void navigateToHomepage(String url) { _driver.get(url); }
	public static void navigateToLink(WebElement link) { link.click(); }
}
