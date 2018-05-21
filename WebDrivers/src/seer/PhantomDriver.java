package seer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomDriver {
	public static final String PHANTOMJS_PATH = System.getProperty("user.dir")
			+ "/WebDriverDependencies/phantomjs.exe";
	
	private static WebDriver _driver = null;
	
	public static WebDriver getPhantomDriver() {
		if (_driver == null) {
			// set phantomjs.exe file path via DesiredCapabilities
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability(PhantomJSDriverService
					.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, PHANTOMJS_PATH);
			
			_driver = new PhantomJSDriver(capability);
		}
		
		return _driver;
	}
}
