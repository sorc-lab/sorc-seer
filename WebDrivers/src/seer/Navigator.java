package seer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Navigator {
	void navigateToHomepage();
	List<WebElement> getAllNavigationLinkElements();
	boolean checkNavigationLinks(List<WebElement> links) throws Exception;
	void navigateToLink(WebElement link);
	void navigateToNextLink(By linkLocator);
}
