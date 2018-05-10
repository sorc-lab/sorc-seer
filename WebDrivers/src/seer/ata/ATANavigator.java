package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.Helper;
import seer.Navigator;

public class ATANavigator implements Navigator {
	public static  String HOME="http://www.ata-tarot.com/resource/cards/index.html";
	public static  String[] LINKS = { "The Fool", "The Magician",
		"The High Priestess", "The Empress", "The Emperor",
		"The Hierophant", "The Lovers", "The Chariot", "Strength",
		"The Hermit", "Wheel of Fortune", "Justice", "The Hanged Man",
		"Death", "Temperance", "The Devil", "The Tower", "The Star",
		"The Moon", "The Sun", "Judgement", "The World", "Ace of Cups",
		"Two of Cups", "Three of Cups", "Four of Cups", "Five of Cups",
		"Six of Cups", "Seven of Cups", "Eight of Cups", "Nine of Cups",
		"Ten of Cups", "Page of Cups", "Knight of Cups", "Queen of Cups",
		"King of Cups", "Ace of Pentacles", "Two of Pentacles",
		"Three of Pentacles", "Four of Pentacles", "Five of Pentacles",
		"Six of Pentacles", "Seven of Pentacles", "Eight of Pentacles",
		"Nine of Pentacles", "Ten of Pentacles", "Page of Pentacles",
		"Knight of Pentacles", "Queen of Pentacles", "King of Pentacles",
		"Ace of Swords", "Two of Swords", "Three of Swords",
		"Four of Swords", "Five of Swords", "Six of Swords",
		"Seven of Swords", "Eight of Swords", "Nine of Swords",
		"Ten of Swords", "Page of Swords", "Knight of Swords",
		"Queen of Swords", "King of Swords", "Ace of Wands", "Two of Wands",
		"Three of Wands", "Four of Wands", "Five of Wands", "Six of Wands",
		"Seven of Wands", "Eight of Wands", "Nine of Wands", "Ten of Wands",
		"Page of Wands", "Knight of Wands", "Queen of Wands",
		"King of Wands"
	};
	
	private WebDriver _driver;
	private FrameSwitch _frameSwitch;
	
	public ATANavigator(WebDriver driver) {
		this._driver = driver;
		this._frameSwitch = new FrameSwitch(_driver);
	}
	
	@Override
	public void navigateToHomepage() { _driver.get(HOME); }
	
	@Override
	public List<WebElement> getAllNavigationLinkElements() {
		_frameSwitch.switchToNavigationFrame();
		List<WebElement> navigationLinks=_driver.findElements(By.tagName("a"));
		
		// remove 'Introduction' and 'Back to Resources' links 
		navigationLinks.remove(0);
		navigationLinks.remove(0);
		
		try {
			if (checkNavigationLinks(navigationLinks))
				return navigationLinks;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(
				"Making second attempt at acquiring navigation links..."
			);
			Helper helper = new Helper(_driver);
			
			// clear out first attempt at acquiring navigation links
			navigationLinks.clear();
			
			for (int i = 0; i < LINKS.length; i++) {
				By locator = By.partialLinkText(LINKS[i]);
				WebElement navLink = helper.getPresentWebElement(locator);
				navigationLinks.add(navLink);
			}
		}
		return navigationLinks; 
	}
	
	@Override
	public boolean checkNavigationLinks(List<WebElement> links)
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
	
	@Override
	public void navigateToLink(WebElement link) { link.click(); }
	
	@Override
	public void navigateToNextLink(By linkLocator) {
		Helper helper = new Helper(_driver);
		WebElement link = helper.getPresentWebElement(linkLocator);
		navigateToLink(link);
		_frameSwitch.switchToDataFrame();
	}
}
