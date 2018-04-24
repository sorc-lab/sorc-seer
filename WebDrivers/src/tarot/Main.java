package tarot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main
{	
	public static void main(String[] args) throws Exception
	{
		SetupWebDriver setup = new SetupWebDriver();
		WebDriver driver = setup.getWebDriver();
		driver.get("http://www.ata-tarot.com/resource/cards/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageTitle = (String) js.executeScript("return document.title");
		System.out.println("Page title: " + pageTitle);
		
		// replace w/ fluent wait
		Thread.sleep(2000); // probably needs try/catch
		
		try {
			driver.switchTo().frame(driver.findElement(By.name("FRA")));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
		
		//driver.switchTo().frame(driver.findElement(By.name("FRA")));
		driver.findElement(By.partialLinkText("King of Swords")).click();
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent(); // cannot switch frame index w/o it
		
		try {
			//driver.switchTo().frame(1);
			driver.switchTo().frame(driver.findElement(By.name("FRB")));
		} catch(NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
		
		// get all <p> within body of frame name="FRB"
		List<WebElement> elems = driver.findElements(By.tagName("p"));
		for (WebElement elem : elems) {
			System.out.println(elem.getText());
		}
		
		
		// KEEP FOR A BIT
		//String tmp = "maj00.html";
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(kingOfSwords)));
		//driver.findElement(By.partialLinkText("King of Swords Meaning")).click();
		
		
	}
}
