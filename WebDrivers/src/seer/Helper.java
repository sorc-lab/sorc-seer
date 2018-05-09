package seer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Temporary class to store help functions */
public class Helper {
	private WebDriver _driver;
	
	public Helper(WebDriver driver) { this._driver = driver; }
	
	public WebElement getPresentWebElement(By locator) {
		WebElement element = (new WebDriverWait(_driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
}
