package seer;

import org.openqa.selenium.WebDriver;

import seer.ata.ATAHarvester;
import seer.ata.ATASetup;
import seer.tt.TTHarvester;
import seer.tt.TTSetup;

public class Main {	
	public static void main(String[] args) throws Exception {
		WebDriver driver = new PhantomDriver().getPhantomDriver();
		
		/*
		Setup setupATA = new ATASetup(driver);
		setupATA.setupHarvester();
		ATAHarvester ATAHarvester = new ATAHarvester(driver);
		ATAHarvester.harvest();
		*/
		
		Setup setupTT = new TTSetup(driver);
		setupTT.setupHarvester();
		
		//TTHarvester TTHarvester = new TTHarvester(driver);
		//TTHarvester.harvest();
	}	
}
