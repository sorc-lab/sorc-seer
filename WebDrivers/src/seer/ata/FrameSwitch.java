package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

public class FrameSwitch {
	public static  String NAVIGATION_FRAME = "FRA";
	public static  String DATA_FRAME = "FRB";
	
	WebDriver _driver;
	
	public FrameSwitch(WebDriver driver) { this._driver = driver; }
	
	private void _switchToDefaultFrame() {_driver.switchTo().defaultContent();}
	
	public void switchToNavigationFrame() {
		_switchToDefaultFrame();
		By navigationFrame = By.name(NAVIGATION_FRAME);
		try {
			_driver.switchTo().frame(_driver.findElement(navigationFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void switchToDataFrame() {
		_switchToDefaultFrame();
		By dataFrame = By.name(DATA_FRAME);
		try {
			_driver.switchTo().frame(_driver.findElement(dataFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
}
