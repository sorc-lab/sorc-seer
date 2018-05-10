package seer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractGetData {
	private WebDriver _driver;
	
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
	abstract protected boolean checkNavigationLinks_(List<WebElement> links)
	throws Exception;
}
