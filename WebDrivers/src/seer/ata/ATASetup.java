package seer.ata;

import seer.HarvesterIO;
import seer.PhantomDriver;

public class ATASetup {
	public static final String ROOT_DIR = "ATATarot";
	public static final String FILE_EXT = "_ata.txt";
	public static final String HOMEPAGE_URL = 
		"http://www.ata-tarot.com/resource/cards/index.html";
	
	private static HarvesterIO _io;
	
	public static void setupHarvester() {
		ATANavigator.navigateToHomepage(HOMEPAGE_URL);
		ATAFrameSwitch.switchToNavigationFrame();
		
		// TEST
		System.out.println(PhantomDriver.getPhantomDriver().getTitle());
		// ***
		
		// TODO: Fix HarvesterIO so that it does not need a constructor
		_io = new HarvesterIO(ROOT_DIR, FILE_EXT);
		_io.createDirectory(ROOT_DIR);
	}
}
