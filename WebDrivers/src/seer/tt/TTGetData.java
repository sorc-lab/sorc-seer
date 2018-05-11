package seer.tt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractGetData;

public class TTGetData extends AbstractGetData {
	private WebDriver _driver;

	public TTGetData(WebDriver driver) {
		super(driver);
		this._driver = driver;
	}

	@Override
	public List<WebElement> getAllNavigationLinkElements() {
		List<WebElement> navLinks = _driver.findElements(By.tagName("a"));
		return navLinks;
	}
	
	// TODO: Check navigation links
	@Override
	protected boolean checkNavigationLinks_(List<WebElement> navLinks)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getHeader() {
		By locator = By.tagName("h1");
		WebElement headerElement = super.getPresentWebElement(locator);
		String header = headerElement.getText();
		return header;
	}
	
	public String getSummary() {
		By locator = By.cssSelector("body > div.paper > div > p:nth-child(3)");
		WebElement summaryElement = super.getPresentWebElement(locator);
		String summary = summaryElement.getText();
		return summary;
	}
}
