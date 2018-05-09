package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.Helper;

public class ATANavigator {
	public static final String HOME="http://www.ata-tarot.com/resource/cards/";
	public static final String NAVIGATION_FRAME = "FRA";
	public static final String DATA_FRAME = "FRB";
	
	public static final String[] CARDS = { "The Fool", "The Magician",
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
	
	public ATANavigator(WebDriver driver) { this._driver = driver; }
	
	public void navigateHomepage() { _driver.get(HOME); }
	private void _switchToDefaultFrame() {_driver.switchTo().defaultContent();}
	
	public void switchToNavigationFrame() {
		_switchToDefaultFrame();
		By navigationFrame = By.name(NAVIGATION_FRAME);
		try {
			_driver.switchTo().frame(_driver.findElement(navigationFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void switchToDataFrame() {
		_switchToDefaultFrame();
		By dataFrame = By.name(DATA_FRAME);
		try {
			_driver.switchTo().frame(_driver.findElement(dataFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<WebElement> getAllNavigationLinkElements() {
		_switchToDefaultFrame();
		switchToNavigationFrame();
		List<WebElement> navigationLinks = _driver.findElements(By.tagName("a"));
		
		// remove 'Introduction' and 'Back to Resources' links 
		navigationLinks.remove(0);
		navigationLinks.remove(0);
		
		try {
			if (_checkNavigationLinks(navigationLinks))
				return navigationLinks;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(
				"Making second attempt at acquiring navigation links..."
			);
			Helper helper = new Helper(_driver);
			
			// clear out first attempt at acquiring navigation links
			navigationLinks.clear();
			
			for (int i = 0; i < CARDS.length; i++) {
				By locator = By.partialLinkText(CARDS[i]);
				WebElement navLink = helper.getPresentWebElement(locator);
				navigationLinks.add(navLink);
			}
		}
		return navigationLinks; 
	}
	
	private boolean _checkNavigationLinks(List<WebElement> links)
	throws Exception
	{
		boolean isValid = true;
		
		if (links.size() == CARDS.length) {
			for (int i = 0; i < CARDS.length; i++) {
				String linkTxt = links.get(i).getText();
				if (!linkTxt.equals(CARDS[i])) {
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
	
	public void navigateToLink(final WebElement link) { link.click(); }
	
	public void navigateToNextLink(By linkLocator) {
		Helper helper = new Helper(_driver);
		WebElement link = helper.getPresentWebElement(linkLocator);
		navigateToLink(link);
		this.switchToDataFrame();
	}
}
