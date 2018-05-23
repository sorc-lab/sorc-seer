package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seer.GetHarvesterData;
import seer.HarvesterIO;

public class ATAHarvester {
	public static final String ATA_DATA_DIR = "ATATarot";
	public static final String ATA_DATA_FILE_EXT = "_ata.txt";
	
	private List<WebElement> _navLinkElements;
	private String[] _navLinkTexts;
	
	public ATAHarvester() {
		_navLinkElements = GetHarvesterData.getAllATANavigationLinkElements();
		_navLinkTexts = GetHarvesterData
				.getTextValuesFromLinkElements(_navLinkElements);
	}
	
	public void harvest() throws Exception {
		for (int i = 0; i < _navLinkElements.size(); i++) {
			ATAFrameSwitch.switchToNavigationFrame();
			String linkText = _navLinkTexts[i];
						
			System.out.println("Harvesting data: " + linkText + " ...");
			By linkLocator = By.partialLinkText(linkText);
			ATANavigator.navigateToNextLink(linkLocator);
			
			String[] paragraphs = GetHarvesterData.getParagraphs();
			
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
