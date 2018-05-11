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
	public static final String HOMEPAGE_URL =
			"https://www.trustedtarot.com/card-meanings/";
	
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
			WebElement link = _getData.getPresentWebElement(linkLocator);
			_nav.navigateToLink(link);
			
			paragraphs_ = _getData.getParagraphs();
			String[] data = {
				_getData.getHeader(),
				_getData.getSummary(),
				paragraphs_[2],
				"Past",
				paragraphs_[3],
				"Present",
				paragraphs_[4],
				"Future",
				paragraphs_[5]
			};
			
			paragraphs_ = data;
			performHarvesterIO_();
			_nav.navigateToHomepage(HOMEPAGE_URL);
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
