package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractGetData;
import seer.PhantomDriver;

public class ATAGetData extends AbstractGetData {
	private static WebDriver _driver = PhantomDriver.getPhantomDriver();
	
	@Override
	public List<WebElement> getAllNavigationLinkElements() {
		ATAFrameSwitch.switchToNavigationFrame();
		List<WebElement> navLinks=_driver.findElements(By.tagName("a"));
		navLinks.remove(0); // remove first two links
		navLinks.remove(0);
		try {
			if (checkNavigationLinks_(navLinks))
				return navLinks;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(
				"Making second attempt at acquiring navigation links..."
			);
			navLinks.clear(); // clear first attempt
			for (int i = 0; i < links_.length; i++) {
				By locator = By.partialLinkText(links_[i]);
				WebElement navLink = getPresentWebElement(locator);
				navLinks.add(navLink);
			}
		}
		return navLinks; 
	}
	
	@Override
	protected boolean checkNavigationLinks_(List<WebElement> navLinks)
	throws Exception
	{
		boolean isValid = true;
		if (navLinks.size() == links_.length) {
			for (int i = 0; i < links_.length; i++) {
				String linkTxt = navLinks.get(i).getText();
				if (!linkTxt.equals(links_[i])) {
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
