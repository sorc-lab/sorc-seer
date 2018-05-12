package seer.tt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

	public TTHarvester(WebDriver driver) {
		super(ROOT_DIR, FILE_EXT);
		this._driver = driver;
		
		_nav     = new TTNavigator(_driver);
		_getData = new TTGetData(_driver);
		
		_navLinkElements = _getData.getAllNavigationLinkElements();
		_filterNavigationLinkElements(_navLinkElements);
		
		_navLinkTexts = _getData
			.getTextValuesFromLinkElements(_navLinkElements);
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
			_saveImage();
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
	
	private void _saveImage() throws IOException {
		List<WebElement> images = _driver.findElements(By.tagName("img"));
		WebElement imageElement = images.get(1);
		String imageURL = imageElement.getAttribute("src");
		URL url = new URL(imageURL);
		
		// avoid 403 Forbidden response. trick server. we look like a browser
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
	    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");
	    
	    String[] splitUrl = imageURL.split("/");
	    String getFileName = splitUrl[splitUrl.length - 1];
	    String fileDestination =
	    	ROOT_DIR + "/" + linkText_.replaceAll(" ", "_") + "/" + getFileName;
		
	    InputStream in = httpcon.getInputStream();
	    OutputStream out = new FileOutputStream(fileDestination);
	    byte[] buf = new byte[2048];
	    int length;
	    
	    while ((length = in.read(buf)) != -1)
	    	out.write(buf, 0, length);
	    
	    in.close();
	    out.close();
	}
}
