package seer.tt;

import org.openqa.selenium.WebDriver;

import seer.HarvesterIO;
import seer.Setup;

public class TTSetup implements Setup {
	public static final String ROOT_DIR = "TTTarot";
	public static final String FILE_EXT = "_tt.txt";
	public static final String HOMEPAGE_URL =
		"https://www.trustedtarot.com/card-meanings/";
	
	private WebDriver _driver;
	private TTNavigator _nav;
	private HarvesterIO _io;
	
	public TTSetup(WebDriver driver) {
		this._driver = driver;
		_nav = new TTNavigator(_driver);
		_io = new HarvesterIO(ROOT_DIR, FILE_EXT);
	}
	
	@Override
	public void setupHarvester() {
		_nav.navigateToHomepage(HOMEPAGE_URL);
		_io.createDirectory(ROOT_DIR);
	}
}
