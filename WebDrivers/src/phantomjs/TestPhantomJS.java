package phantomjs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

// just install this weakness via Eclipse marketplace
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestPhantomJS
{
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception
	{
		String baseDir = System.getProperty("user.dir");
		String phantomjs = baseDir + "/WebDriverDependencies/phantomjs.exe";
		
		// set phantomjs.exe file path via DesiredCapabilities
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(
			PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			phantomjs
		);	
		driver = new PhantomJSDriver(capability);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void phantomTest() throws IOException
	{
		driver.get("https://www.google.com");
		
		// get title via JS executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageTitle = (String) js.executeScript("return document.title");
		System.out.println("Page title: " + pageTitle);
		
		// get some elements to test out...
	}
}
