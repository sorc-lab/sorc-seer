package seer.ata;

import org.openqa.selenium.WebDriver;

import seer.FileGenerator;
import seer.Setup;

public class ATASetup implements Setup {
	private WebDriver _driver;
	private ATANavigator _nav;
	private FrameSwitch _frameSwitch;
	private FileGenerator _fileGen;
	private String _homepage="http://www.ata-tarot.com/resource/cards/index.html";
	
	public ATASetup(WebDriver driver) {
		this._driver = driver;
		_nav = new ATANavigator(_driver);
		_frameSwitch = new FrameSwitch(_driver);
		_fileGen = new ATAFileGenerator();
	}
	
	@Override
	public void setupScraper() {
		_nav.navigateToHomepage(_homepage);
		_frameSwitch.switchToNavigationFrame();
		_fileGen.generateDirectory();
	}
}
