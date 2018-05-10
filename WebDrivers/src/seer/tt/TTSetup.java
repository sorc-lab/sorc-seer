package seer.tt;

import org.openqa.selenium.WebDriver;

import seer.Setup;

public class TTSetup implements Setup {
	public static final String HOMEPAGE_URL =
		"https://www.trustedtarot.com/card-meanings/";
	
	private WebDriver _driver;
	private TTNavigator _nav;
	
	public TTSetup(WebDriver driver) {
		this._driver = driver;
		_nav = new TTNavigator(_driver);
	}
	
	@Override
	public void setupHarvester() {
		_nav.navigateToHomepage(HOMEPAGE_URL);
		
		// TEST START
		System.out.println(_driver.getTitle());
		// TEST END
	}
}
