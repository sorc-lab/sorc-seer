package seer.ata;

import org.openqa.selenium.WebDriver;

import seer.HarvesterIO;
import seer.Setup;

public class ATASetup implements Setup {
	public static final String ROOT_DIR = "ATATarot";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	private WebDriver _driver;
	private ATANavigator _nav;
	private FrameSwitch _frameSwitch;
	private HarvesterIO _io;
	
	public ATASetup(WebDriver driver) {
		this._driver = driver;
		_nav = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_io = new HarvesterIO("ATATarot", "_ata.txt");
	}
	
	@Override
	public void setupHarvester() {
		_nav.navigateToHomepage(HOMEPAGE_URL);
		_frameSwitch.switchToNavigationFrame();
		_io.createDirectory(ROOT_DIR);
	}
}
