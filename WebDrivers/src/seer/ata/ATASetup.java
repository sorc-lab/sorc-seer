package seer.ata;

import org.openqa.selenium.WebDriver;

import seer.ScraperIO;
import seer.Setup;

public class ATASetup implements Setup {
	private static final String ROOT_DIR = "ATATarot";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	private WebDriver _driver;
	private ATANavigator _nav;
	private FrameSwitch _frameSwitch;
	private ScraperIO _io;
	
	public ATASetup(WebDriver driver) {
		this._driver = driver;
		_nav = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_io = new ScraperIO("ATATarot", "_ata.txt");
	}
	
	@Override
	public void setupScraper() {
		_nav.navigateToHomepage(HOMEPAGE_URL);
		_frameSwitch.switchToNavigationFrame();
		_io.createDirectory(ROOT_DIR);
	}
}
