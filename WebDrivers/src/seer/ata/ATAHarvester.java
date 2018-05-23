package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seer.GetHarvesterData;
import seer.HarvesterIO;

public class ATAHarvester {
	public static final String ATA_DATA_DIR = "ATATarot";
	public static final String ATA_DATA_FILE_EXT = "_ata.txt";
	
	public static void harvest() throws Exception {
		List<WebElement> navLinkElements = ATAGetData
				.getAllATANavigationLinkElements();
		
		String[] navLinkTexts = GetHarvesterData
				.getTextValuesFromLinkElements(navLinkElements);
		
		for (int i = 0; i < navLinkElements.size(); i++) {
			ATAFrameSwitch.switchToNavigationFrame();
			String linkText = navLinkTexts[i];
						
			System.out.println("Harvesting data: " + linkText + " ...");
			By linkLocator = By.partialLinkText(linkText);
			ATANavigator.navigateToNextLink(linkLocator);
			
			String[] paragraphs = ATAGetData.getParagraphs();
			
			HarvesterIO io = new HarvesterIO.Builder()
					.setDir(ATA_DATA_DIR)
					.setFileExt(ATA_DATA_FILE_EXT)
					.setLinkText(linkText)
					.setParagraphs(paragraphs)
					.build();
			
			io.performHarvesterIO();
		}
	}
}
