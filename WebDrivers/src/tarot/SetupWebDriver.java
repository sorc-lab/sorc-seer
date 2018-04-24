package tarot;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetupWebDriver
{
	private WebDriver _driver;
	
	public WebDriver getWebDriver()
	{
		String baseDir = System.getProperty("user.dir");
		String phantomjs = baseDir + "/WebDriverDependencies/phantomjs.exe";
		
		// set phantomjs.exe file path via DesiredCapabilities
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(
			PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			phantomjs
		);	
		_driver = new PhantomJSDriver(capability);
		_driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return _driver;
	}
}
