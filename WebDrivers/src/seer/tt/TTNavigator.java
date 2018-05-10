package seer.tt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seer.AbstractNavigator;

public class TTNavigator extends AbstractNavigator {

	public TTNavigator(WebDriver driver) { super(driver); }

	@Override
	public void navigateToNextLink(By linkLocator) { /* ... */ }
}
