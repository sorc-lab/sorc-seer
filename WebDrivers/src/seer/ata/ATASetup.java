package seer.ata;

import org.openqa.selenium.WebDriver;

import seer.FileGenerator;
import seer.Navigator;
import seer.Setup;

public class ATASetup implements Setup {
	private WebDriver _driver;
	private Navigator _nav;
	private FrameSwitch _frameSwitch;
	private FileGenerator _fileGen;
	
	public ATASetup(WebDriver driver) {
		this._driver = driver;
		_nav = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_fileGen = new ATAFileGenerator();
	}
	
	@Override
	public void setupScraper() {
		_nav.navigateToHomepage();
		_frameSwitch.switchToNavigationFrame();
		_fileGen.generateDirectory();
	}
}
