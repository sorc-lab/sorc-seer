package seer;

import org.openqa.selenium.WebDriver;

import seer.ata.ATAHarvester;
import seer.ata.ATASetup;

public class Main {	
	public static void main(String[] args) throws Exception {
		WebDriver driver = new PhantomDriver().getPhantomDriver();
		Setup setup = new ATASetup(driver);
		setup.setupHarvester();
		
		ATAHarvester ATAHarvester = new ATAHarvester(driver);
		ATAHarvester.harvest();		
	}	
}
