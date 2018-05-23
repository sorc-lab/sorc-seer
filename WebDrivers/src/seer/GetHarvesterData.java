package seer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetHarvesterData {
	private static WebDriver _driver = PhantomDriver.getPhantomDriver();
	private static String[] _links = Cards.CARD_NAMES;
			
	public static WebElement getPresentWebElement(By locator) {
		WebElement element = (new WebDriverWait(_driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	
	public static String[] getTextValuesFromLinkElements(List<WebElement> links)
	{
		int linksCount = links.size();
		String[] textValues = new String[linksCount];
		int i = 0;
		for (WebElement link : links) {
			textValues[i] = link.getText();
			i++;
		}
		return textValues;
	}
	
	public static String[] getParagraphs() {
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
	
	public static boolean checkNavigationLinks(List<WebElement> navLinks)
	throws Exception
	{
		boolean isValid = true;
		if (navLinks.size() == _links.length) {
			for (int i = 0; i < _links.length; i++) {
				String linkTxt = navLinks.get(i).getText();
				if (!linkTxt.equals(_links[i])) {
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
