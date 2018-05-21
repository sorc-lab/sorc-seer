package seer.ata;

import seer.HarvesterIO;

public class ATASetup {
	public static final String ROOT_DIR = "ATATarot";
	public static final String FILE_EXT = "_ata.txt";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	public static void setupHarvester() {
		ATANavigator.navigateToHomepage(HOMEPAGE_URL);
		ATAFrameSwitch.switchToNavigationFrame();
		
		// TODO: Consider making this a singleton w/ getDir() and getFileExt()
		HarvesterIO io = new HarvesterIO(ROOT_DIR, FILE_EXT);
		io.createDirectory(ROOT_DIR);
	}
}
