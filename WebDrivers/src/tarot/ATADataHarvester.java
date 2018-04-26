package tarot;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ATADataHarvester
{
	public void harvest()
	{
		ATANavigator ATANavigator = new ATANavigator(); 
		ATANavigator.navigateHomepage();
		ATANavigator.switchToDefaultFrame();
		ATANavigator.switchToNavigationFrame();
		List<WebElement> navigationLinks = ATANavigator.getAllNavigationLinks();
		
		ATAFileGenerator fileGenerator = new ATAFileGenerator();
		fileGenerator.generateDirectory();
		
		for (WebElement link : navigationLinks) {
			fileGenerator.generateTextFile(link);
		}
	}
}
