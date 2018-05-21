package seer.ata;

import seer.HarvesterIO;

public class ATASetup {
	public static final String ROOT_DIR = "ATATarot";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	public static void setupHarvester() {
		ATANavigator.navigateToHomepage(HOMEPAGE_URL);
		ATAFrameSwitch.switchToNavigationFrame();
		HarvesterIO.createDirectory(ROOT_DIR);
	}
}
