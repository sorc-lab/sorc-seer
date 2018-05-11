package seer.tt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	// TODO: Refactor for readability via this code:
	// https://www.avajava.com/tutorials/lessons/how-do-i-save-an-image-from-a-url-to-a-file.html
	private void _saveImage() throws IOException {
		By locator = By.tagName("img");
		List<WebElement> images = _driver.findElements(locator);
		WebElement imageElement = images.get(1);
		String imageUrl = imageElement.getAttribute("src");
		
		
		
		
		
		URL url = new URL(imageUrl);
		
		// avoid 403 Forbidden response. trick server. we look like a browser
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
	    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");
		
		
		
		
		
		//InputStream in = new BufferedInputStream(url.openStream());
	    InputStream in = httpcon.getInputStream();
	    
	    
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1!=(n=in.read(buf))) { // ???
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();
		
		FileOutputStream fos = new FileOutputStream("M://test.png");
		fos.write(response);
		fos.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
