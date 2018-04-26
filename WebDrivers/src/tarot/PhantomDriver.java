package tarot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomDriver
{
	public static WebDriver driver;
	
	public void initializePhantomDriver()
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
	}
}
