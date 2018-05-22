package seer.ata;

import seer.HarvesterIO;

public class ATASetup {
	public static final String ATA_DATA_DIR = "ATATarot";
	public static final String ATA_DATA_FILE_EXT = "_ata.txt";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	public static void setupHarvester() {
		ATANavigator.navigateToHomepage(HOMEPAGE_URL);
		ATAFrameSwitch.switchToNavigationFrame();
		HarvesterIO io = new HarvesterIO.Builder().setDir(ATA_DATA_DIR).build();
		io.createDirectory(ATA_DATA_DIR);
	}
}
