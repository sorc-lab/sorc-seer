package tarot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Temporary class to store help functions */
public class Helper extends PhantomDriver
{
	public WebElement getPresentWebElement(By locator)
	{
		WebElement element = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
}
