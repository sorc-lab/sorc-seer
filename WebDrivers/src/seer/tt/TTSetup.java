package seer.tt;

import seer.HarvesterIO;

public class TTSetup {
	public static final String TT_DATA_DIR = "TTTarot";
	public static final String TT_DATA_FILE_EXT = "_tt.txt";
	public static final String HOMEPAGE_URL =
		"https://www.trustedtarot.com/card-meanings/";
	
	public static void setupHarvester() {
		TTNavigator.navigateToHomepage(HOMEPAGE_URL);
		HarvesterIO io = new HarvesterIO.Builder().setDir(TT_DATA_DIR).build();
		io.createDirectory(TT_DATA_DIR);
	}
}
