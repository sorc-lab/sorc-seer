package tarot;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;

public class ATAHandler extends PhantomDriver
{
	public static final String HOME = "http://www.ata-tarot.com/resource/cards/";
	public static final String NAVIGATION_FRAME = "FRA";
	
	public void navigateHomepage() { driver.get(HOME); }
	public void switchToDefaultFrame() { driver.switchTo().defaultContent(); }
	
	public void switchToNavigationFrame()
	{
		By navigationFrame = By.name(NAVIGATION_FRAME);
		try {
			driver.switchTo().frame(driver.findElement(navigationFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
}
