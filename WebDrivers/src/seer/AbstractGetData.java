package seer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractGetData {
	private WebDriver _driver;
	
	protected String[] links_ = { "The Fool", "The Magician",
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
	
	public AbstractGetData(WebDriver driver) { this._driver = driver; }
	
	public WebElement getPresentWebElement(By locator) {
		WebElement element = (new WebDriverWait(_driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	
	public String[] getTextValuesFromLinkElements(List<WebElement> links) {
		int linksCount = links.size();
		String[] textValues = new String[linksCount];
		int i = 0;
		for (WebElement link : links) {
			textValues[i] = link.getText();
			i++;
		}
		return textValues;
	}
	
	public String[] getParagraphs() {
		List<WebElement> elements = _driver.findElements(By.tagName("p")); 
		int numberOfParagraphs = elements.size();
		String[] paragraphs = new String[numberOfParagraphs];	
		int i = 0;
		for (WebElement element : elements) {
			paragraphs[i] = element.getText();
			i++;
		}
		return paragraphs;
	}
	
	abstract public List<WebElement> getAllNavigationLinkElements();
	abstract protected boolean checkNavigationLinks_(List<WebElement> navLinks)
	throws Exception;
}
