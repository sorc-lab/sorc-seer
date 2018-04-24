package tarot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Main
{	
	public static void main(String[] args) throws Exception
	{
		SetupWebDriver setup = new SetupWebDriver();
		WebDriver driver = setup.getWebDriver();
		
		driver.get("http://www.google.com");
		
		// get title via JS executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageTitle = (String) js.executeScript("return document.title");
		System.out.println("Page title: " + pageTitle); 
	}
}
