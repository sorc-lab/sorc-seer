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

import seer.HarvesterIO;
import seer.PhantomDriver;

public class TTHarvester {
	public static final String TT_DATA_DIR = "TTTarot";
	public static final String TT_DATA_FILE_EXT = "_tt.txt";
	public static final String HOMEPAGE_URL =
			"https://www.trustedtarot.com/card-meanings/";
	
	private static WebDriver _driver = PhantomDriver.getPhantomDriver();
	private static String _linkText;

	public static void harvest() throws Exception {
		List<WebElement> navLinkElements = TTGetData
				.getAllNavigationLinkElements();
		
		String[] navLinkTexts = TTGetData
				.getTextValuesFromLinkElements(navLinkElements);
				
		for (int i = 0; i < navLinkElements.size(); i++) {
			_linkText = navLinkTexts[i];
			System.out.println("Harvesting data: " + _linkText + " ...");
			
			By linkLocator = By.partialLinkText(_linkText);
			WebElement link = TTGetData.getPresentWebElement(linkLocator);
			TTNavigator.navigateToLink(link);
			
			String[] paragraphs = TTGetData.getParagraphs();
			String[] data = {
				TTGetData.getHeader(),
				TTGetData.getSummary(),
				paragraphs[2],
				"Past",
				paragraphs[3],
				"Present",
				paragraphs[4],
				"Future",
				paragraphs[5]
			};
			
			paragraphs = data;
			
			HarvesterIO io = new HarvesterIO.Builder()
					.setDir(TT_DATA_DIR)
					.setFileExt(TT_DATA_FILE_EXT)
					.setLinkText(_linkText)
					.setParagraphs(paragraphs)
					.build();
			
			io.performHarvesterIO();
			_saveImage();
			TTNavigator.navigateToHomepage(HOMEPAGE_URL);
		}
	}
	
	// TODO: Why is this not being used?
	private static List<WebElement> _filterNavigationLinkElements
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
	
	private static void _saveImage() throws IOException {
		List<WebElement> images = _driver.findElements(By.tagName("img"));
		WebElement imageElement = images.get(1);
		String imageURL = imageElement.getAttribute("src");
		URL url = new URL(imageURL);

		// avoid 403 Forbidden response. trick server. we look like a browser
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");

		String[] splitUrl = imageURL.split("/");
		String getFileName = splitUrl[splitUrl.length - 1];
		String fileDestination = TT_DATA_DIR + "/"
				+ _linkText.replaceAll(" ", "_") + "/" + getFileName;

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
