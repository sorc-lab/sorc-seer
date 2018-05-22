package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractHarvester;
import seer.GetHarvesterData;
import seer.PhantomDriver;

public class ATAHarvester extends AbstractHarvester {
	public static final String ATA_DATA_DIR = "ATATarot";
	public static final String ATA_DATA_FILE_EXT = "_ata.txt";
	
	private List<WebElement> _navLinkElements;
	private String[] _navLinkTexts;
	
	public ATAHarvester() {
		// TODO: Look into removing AbstractHarvester
		super(ATA_DATA_DIR, ATA_DATA_FILE_EXT);
				
		_navLinkElements = GetHarvesterData.getAllATANavigationLinkElements();
		_navLinkTexts = GetHarvesterData
				.getTextValuesFromLinkElements(_navLinkElements);
	}
	
	@Override
	public void harvest() throws Exception {
		for (int i = 0; i < _navLinkElements.size(); i++) {
			ATAFrameSwitch.switchToNavigationFrame();
			linkText_ = _navLinkTexts[i];
						
			System.out.println("Harvesting data: " + linkText_ + " ...");
			By linkLocator = By.partialLinkText(linkText_);
			ATANavigator.navigateToNextLink(linkLocator);
			
			paragraphs_ = GetHarvesterData.getParagraphs();
			performHarvesterIO_();
		}
	}
}
