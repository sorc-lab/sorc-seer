package seer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Navigator {
	void navigateToHomepage();
	void navigateToLink(WebElement link);
	void navigateToNextLink(By linkLocator);
}
