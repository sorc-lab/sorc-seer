package seer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import seer.ata.ATAScraper;
import seer.ata.ATASetup;

public class Main {	
	public static void main(String[] args) throws Exception {
		WebDriver driver = new PhantomDriver().getPhantomDriver();
		Setup setup = new ATASetup(driver);
		setup.setupScraper();
		
		
		// TODO: Fix to be interface w/ type Scraper
		ATAScraper ATAScraper = new ATAScraper(driver);
		
		try {
			ATAScraper.scrape();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
