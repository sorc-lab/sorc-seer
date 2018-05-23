package seer.tt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.GetHarvesterData;
import seer.PhantomDriver;

public class TTGetData extends GetHarvesterData {
	private static WebDriver _driver = PhantomDriver.getPhantomDriver();

	public static List<WebElement> getAllNavigationLinkElements() {
		List<WebElement> navLinks = _driver.findElements(By.tagName("a"));
		return navLinks;
	}
	
	public static String getHeader() {
		By locator = By.tagName("h1");
		WebElement headerElement = getPresentWebElement(locator);
		String header = headerElement.getText();
		return header;
	}
	
	public static String getSummary() {
		By locator = By.cssSelector("body > div.paper > div > p:nth-child(3)");
		WebElement summaryElement = getPresentWebElement(locator);
		String summary = summaryElement.getText();
		return summary;
	}
}
