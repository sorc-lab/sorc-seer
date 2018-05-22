package seer.ata;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractHarvester;
import seer.PhantomDriver;
import seer.ata.ATAGetData;

public class ATAHarvester extends AbstractHarvester {
	public static final String ATA_DATA_DIR = "ATATarot";
	public static final String ATA_DATA_FILE_EXT = "_ata.txt";
	
	private ATAGetData _getData;
	private List<WebElement> _navLinkElements;
	private String[] _navLinkTexts;
	
	public ATAHarvester() {
		// TODO: Look into removing AbstractHarvester
		super(ATA_DATA_DIR, ATA_DATA_FILE_EXT);
		
		// TODO: Look into making this a static util. class--would lose Abstract
		_getData = new ATAGetData();
		
		_navLinkElements = _getData.getAllNavigationLinkElements();
		_navLinkTexts = _getData
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
			
			paragraphs_ = _getData.getParagraphs();
			performHarvesterIO_();
		}
	}
}
