package seer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import seer.ata.ATAScraper;

public class Main extends PhantomDriver {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new PhantomDriver().getPhantomDriver();
		ATAScraper ATAScraper = new ATAScraper(driver);
		
		try {
			ATAScraper.scrape();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
