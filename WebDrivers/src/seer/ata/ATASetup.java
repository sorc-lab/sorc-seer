package seer.ata;

import org.openqa.selenium.WebDriver;

import seer.HarvesterIO;
import seer.PhantomDriver;
import seer.Setup;

public class ATASetup implements Setup {
	public static final String ROOT_DIR = "ATATarot";
	public static final String FILE_EXT = "_ata.txt";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	private WebDriver _driver;
	private ATANavigator _nav;
	private FrameSwitch _frameSwitch;
	private HarvesterIO _io;
	
	public ATASetup() {
		
		
		//_frameSwitch = new FrameSwitch(_driver);
		_io = new HarvesterIO(ROOT_DIR, FILE_EXT);
	}
	
	@Override
	public void setupHarvester() {
		_nav = new ATANavigator(); // TODO: Consider ATANavigator as util. class
		_nav.navigateToHomepage(HOMEPAGE_URL);
		
		_frameSwitch = new FrameSwitch();
		_frameSwitch.switchToNavigationFrame();
		_io.createDirectory(ROOT_DIR);
	}
}
