package seer.tt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seer.AbstractHarvester;

public class TTHarvester extends AbstractHarvester {
	public static final String ROOT_DIR = "TTTarot";
	public static final String FILE_EXT = "_tt.txt";
	
	private WebDriver _driver;
	private TTNavigator _nav;
	private TTGetData _getData;
	private List<WebElement> _navLinkElements;
	private String[] _navLinkTexts;
	private HashMap<String, String[]> _data;

	public TTHarvester(WebDriver driver) {
		super(ROOT_DIR, FILE_EXT);
		this._driver = driver;
		
		_nav     = new TTNavigator(_driver);
		_getData = new TTGetData(_driver);
		
		_navLinkElements = _getData.getAllNavigationLinkElements();
		_filterNavigationLinkElements(_navLinkElements);
		
		_navLinkTexts = _getData
			.getTextValuesFromLinkElements(_navLinkElements);
		_data = new HashMap<String, String[]>();
	}

	@Override
	public void harvest() throws Exception {
		for (int i = 0; i < _navLinkElements.size(); i++) {
			linkText_ = _navLinkTexts[i];
			System.out.println("Harvesting data: " + linkText_ + " ...");
			
			By linkLocator = By.partialLinkText(linkText_);
			_nav.navigateToNextLink(linkLocator);
			
			paragraphs_ = _getData.getParagraphs();
			_data.put(linkText_, paragraphs_);
			performHarvesterIO_();
		}
	}
	
	private List<WebElement> _filterNavigationLinkElements
	(List<WebElement> navLinkElements)
	{
		Iterator<WebElement> iter = navLinkElements.iterator();
		String getText;
		
		while (iter.hasNext()) {
			WebElement element = iter.next();
			getText = element.getText();
			
			if (!getText.contains("Meaning")) {
				iter.remove();
			}
		}
		return navLinkElements;
	}
}
