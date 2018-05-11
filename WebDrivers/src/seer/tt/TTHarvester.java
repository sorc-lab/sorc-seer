package seer.tt;

import java.awt.image.BufferedImage;
import java.io.File;
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
			
			
			
			//_downloadImage();
			String imgsrcTest = _getImageSRC();
			URL imgURL = _getImageURL(imgsrcTest);
			
			// outputs the same values
			System.out.println(imgsrcTest); // String
			System.out.println(imgURL); // URL
			
			
			
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
	
	// https://stackoverflow.com/questions/35430198/cant-get-input-stream-from-url-java
	private void _downloadImage() {
		String imageSRC = _getImageSRC();
		try {
			InputStream inputStream = new URL(imageSRC).openStream();
			
			BufferedImage saveImage = ImageIO.read(inputStream);
			ImageIO.write(saveImage, "png", new File(imageSRC));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String _getImageSRC() {
		By locator = By.tagName("img");
		List<WebElement> images = _driver.findElements(locator);
		WebElement imageElement = images.get(1);
		String imageSRC = imageElement.getAttribute("src");
		return imageSRC;
	}
	
	private URL _getImageURL(String imageSRC) {
		try {
			URL imageURL = new URL(imageSRC);
			return imageURL;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
