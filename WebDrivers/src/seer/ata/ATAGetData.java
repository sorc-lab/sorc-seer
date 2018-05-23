package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.Cards;
import seer.GetHarvesterData;
import seer.PhantomDriver;

public class ATAGetData extends GetHarvesterData {
	private static WebDriver _driver = PhantomDriver.getPhantomDriver();
	private static String[] _links = Cards.CARD_NAMES;
	
	public static List<WebElement> getAllATANavigationLinkElements() {
		ATAFrameSwitch.switchToNavigationFrame();
		List<WebElement> navLinks=_driver.findElements(By.tagName("a"));
		navLinks.remove(0); // remove first two links
		navLinks.remove(0);
		
		try {
			if (checkNavigationLinks(navLinks))
				return navLinks;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(
				"Making second attempt at acquiring navigation links..."
			);
			navLinks.clear(); // clear first attempt
			for (int i = 0; i < _links.length; i++) {
				By locator = By.partialLinkText(_links[i]);
				WebElement navLink = getPresentWebElement(locator);
				navLinks.add(navLink);
			}
		}
		
		return navLinks; 
	}
}
