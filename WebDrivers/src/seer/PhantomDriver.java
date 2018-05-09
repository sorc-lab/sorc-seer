package seer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/** Add SorcDriver interface if more drivers are added */
public class PhantomDriver {
	private WebDriver _driver;
	
	public PhantomDriver() {
		String baseDir = System.getProperty("user.dir");
		String phantomjs = baseDir + "/WebDriverDependencies/phantomjs.exe";
		
		// set phantomjs.exe file path via DesiredCapabilities
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(
			PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			phantomjs
		);	
		this._driver = new PhantomJSDriver(capability);
	}
	
	public WebDriver getPhantomDriver() { return this._driver; }
}
