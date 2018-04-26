package tarot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main
{	
	public static void main(String[] args) throws Exception
	{
		SetupWebDriver setup = new SetupWebDriver();
		WebDriver driver = setup.getWebDriver();
		driver.get("http://www.ata-tarot.com/resource/cards/");
		
		
		
		// replace w/ fluent wait
		//Thread.sleep(2000); // probably needs try/catch
		
		// fluent wait for frame "FRA", then try/catch switchTo below
		
		try {
			driver.switchTo().frame(driver.findElement(By.name("FRA")));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
		
		//driver.findElement(By.partialLinkText("King of Swords")).click();
		By cardLinkTxt = By.partialLinkText("King of Swords");
		WebElement card = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(cardLinkTxt));
		card.click();
		
		
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent(); // cannot switch frame index w/o it
		
		try {
			//driver.switchTo().frame(1);
			driver.switchTo().frame(driver.findElement(By.name("FRB")));
		} catch(NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
		
		HashMap<String, String[]> data = new HashMap<String, String[]>();
		
		// get all <p> within body of frame name="FRB"
		List<WebElement> elems = driver.findElements(By.tagName("p"));
		int cnt = elems.size();
		String[] dataTxt = new String[cnt];
		
		int i = 0;
		for (WebElement elem : elems) {
			System.out.println(elem.getText());
			dataTxt[i] = elem.getText();
			i++;
		}
				
		data.put("King of Swords", dataTxt);
		System.out.println(data.get("King of Swords"));
		
		
		// KEEP FOR A BIT
		//String tmp = "maj00.html";
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(kingOfSwords)));
		//driver.findElement(By.partialLinkText("King of Swords Meaning")).click();
		/*
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageTitle = (String) js.executeScript("return document.title");
		System.out.println("Page title: " + pageTitle);
		*/
		
		/*
		Wait wait = new FluentWait(driver)    
			    .withTimeout(30, SECONDS)    
			    .pollingEvery(5, SECONDS)   
			    .ignoring(NoSuchElementException.class);

			WebElement foo = wait.until(new Function() {    
			    public WebElement apply(WebDriver driver) {    
			        return driver.findElement(By.id("foo"));    
			    }
			});
			*/
		
		
	}
}
