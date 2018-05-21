package seer.ata;

import seer.HarvesterIO;

public class ATASetup {
	public static final String ROOT_DIR = "ATATarot";
	public static final String FILE_EXT = "_ata.txt";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	private static ATANavigator _nav;
	private static FrameSwitch _frameSwitch;
	private static HarvesterIO _io;
	
	public static void setupHarvester() {
		// TODO: Consider ATANavigator as util. class
		_nav = new ATANavigator();
		_nav.navigateToHomepage(HOMEPAGE_URL);
		
		_frameSwitch = new FrameSwitch();
		_frameSwitch.switchToNavigationFrame();
		
		// TODO: Fix HarvesterIO so that it does not need a constructor
		_io = new HarvesterIO(ROOT_DIR, FILE_EXT);
		_io.createDirectory(ROOT_DIR);
	}
}
