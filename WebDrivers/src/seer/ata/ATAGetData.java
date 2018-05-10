package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractGetData;

public class ATAGetData extends AbstractGetData {
	private WebDriver _driver;
	private FrameSwitch _frameSwitch;
	
	public ATAGetData(WebDriver driver) {
		super(driver);
		this._driver = driver;
		_frameSwitch = new FrameSwitch(_driver);
	}
	
	@Override
	public List<WebElement> getAllNavigationLinkElements() {
		_frameSwitch.switchToNavigationFrame();
		List<WebElement> navigationLinks=_driver.findElements(By.tagName("a"));
		navigationLinks.remove(0); // remove first two links
		navigationLinks.remove(0);
		try {
			if (checkNavigationLinks_(navigationLinks))
				return navigationLinks;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(
				"Making second attempt at acquiring navigation links..."
			);
			navigationLinks.clear(); // clear first attempt
			for (int i = 0; i < LINKS.length; i++) {
				By locator = By.partialLinkText(LINKS[i]);
				WebElement navLink = getPresentWebElement(locator);
				navigationLinks.add(navLink);
			}
		}
		return navigationLinks; 
	}
	
	@Override
	protected boolean checkNavigationLinks_(List<WebElement> links) 
	throws Exception
	{
		boolean isValid = true;
		if (links.size() == LINKS.length) {
			for (int i = 0; i < LINKS.length; i++) {
				String linkTxt = links.get(i).getText();
				if (!linkTxt.equals(LINKS[i])) {
					isValid = false;
					throw new Exception(
						"Acquired links did not match expected."
					);
				}
			}
		} else {
			isValid = false;
			throw new Exception("Invalid number of links acquired.");
		}
		return isValid;
	}
}
