package tarot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Main
{
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception
	{
		// test CLI execution
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
		
		tmp();
	}
	
	public static void tmp() throws IOException
	{
		driver.get("https://www.google.com");
		
		// get title via JS executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageTitle = (String) js.executeScript("return document.title");
		System.out.println("Page title: " + pageTitle);
		
		// get some elements to test out...
	}
}
