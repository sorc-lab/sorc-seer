package tarot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;

public class ATAHandler extends PhantomDriver
{
	public static final String HOME = "http://www.ata-tarot.com/resource/cards/";
	public static final String NAVIGATION_FRAME = "FRA";
	
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
	
	public void navigateHomepage() { driver.get(HOME); }
	public void switchToDefaultFrame() { driver.switchTo().defaultContent(); }
	
	public void switchToNavigationFrame()
	{
		By navigationFrame = By.name(NAVIGATION_FRAME);
		try {
			driver.switchTo().frame(driver.findElement(navigationFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<WebElement> getAllNavigationLinks()
	{
		switchToDefaultFrame();
		switchToNavigationFrame();
		List<WebElement> navigationLinks = driver.findElements(By.tagName("a"));
		
		// remove 'Introduction' and 'Back to Resources' links 
		navigationLinks.remove(0);
		navigationLinks.remove(0);
		
		// check if links match CARDS
		// if not, loop through manually doing a try/catch wait for each
		// announce this is taking place so that user knows it may take a while
		if (_checkNavigationLinks(navigationLinks))
			System.out.println("SUCCESS: Obtained all navigation links");
		else
			System.out.println("FAILED: Missing navigation links");
			
		return navigationLinks; 
	}
	
	private boolean _checkNavigationLinks(List<WebElement> links)
	{
		if (links.size() == CARDS.length) {
			for (int i = 0; i < CARDS.length; i++) {
				String linkTxt = links.get(i).getText();
				if (!linkTxt.equals(CARDS[i])) {
					return false;
				}
			}
		}
		return true;
	}
}