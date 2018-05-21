package seer.ata;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

import seer.PhantomDriver;

public class FrameSwitch {
	public static final String NAVIGATION_FRAME = "FRA";
	public static final String DATA_FRAME = "FRB";
	
	private static WebDriver _driver = PhantomDriver.getPhantomDriver();
	
	private static void _switchToDefaultFrame() {
		_driver.switchTo().defaultContent();
	}
	
	public static void switchToNavigationFrame() {
		_switchToDefaultFrame();
		By navigationFrame = By.name(NAVIGATION_FRAME);
		try {
			_driver.switchTo().frame(_driver.findElement(navigationFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void switchToDataFrame() {
		_switchToDefaultFrame();
		By dataFrame = By.name(DATA_FRAME);
		try {
			_driver.switchTo().frame(_driver.findElement(dataFrame));
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
}
