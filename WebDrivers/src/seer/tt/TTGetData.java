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

	@Override
	protected boolean checkNavigationLinks_(List<WebElement> navLinks)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
