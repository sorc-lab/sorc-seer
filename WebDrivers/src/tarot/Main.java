package tarot;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main extends PhantomDriver
{
	private static final int LINE_LENGTH = 80;
	private static final String SPACE = " ";
	private static final String EMPTY_STRING = "";
	
	public static void main(String[] args) throws Exception
	{
		PhantomDriver phantomDriver = new PhantomDriver();
		phantomDriver.initializePhantomDriver();
		
		ATAHandler ATA = new ATAHandler();
		ATA.navigateHomepage();
		ATA.switchToDefaultFrame();
		ATA.switchToNavigationFrame();

		By cardLinkTxt = By.partialLinkText("King of Swords");
		WebElement card = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(cardLinkTxt));
		card.click();
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent(); // cannot switch frame index w/o it
		
		try {
			driver.switchTo().frame(driver.findElement(By.name("FRB")));
		} catch(NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
		
		HashMap<String, String[]> data = new HashMap<String, String[]>();
		
		// get all <p> within body of frame name="FRB"
		List<WebElement> elems = driver.findElements(By.tagName("p"));
		int cnt = elems.size();
		String[] dataTxt = new String[cnt];
		
		int i = 0;
		for (WebElement elem : elems) {
			System.out.println(elem.getText());
			dataTxt[i] = elem.getText();
			i++;
		}
				
		data.put("King of Swords", dataTxt);
		System.out.println(data.get("King of Swords"));
		
		FileWriter fileWriter = new FileWriter("king_of_swords.txt");
		String newLine = System.getProperty("line.separator"); // more portable than '\n'
		
		for (i = 0; i < dataTxt.length; i++) {
			String tmp = getPreviewLines(dataTxt[i]);
			fileWriter.write(tmp + newLine);
			fileWriter.write(newLine);
		}
		fileWriter.close();		
	}
	
	public static String getPreviewLines(final String input) 
	{
	    final StringTokenizer token = new StringTokenizer(input, SPACE);
	    final StringBuilder output = new StringBuilder(input.length());

	    int lineLen = 0;

	    while (token.hasMoreTokens()) 
	    {
	        final String word = token.nextToken() + SPACE;

	        if (lineLen + word.length() - 1 > LINE_LENGTH) 
	        {
	            output.append(System.lineSeparator());
	            lineLen = 0;
	        }

	        output.append(word);

	        if (word.contains(System.lineSeparator())) 
	            lineLen = word.replaceAll("\\s+", EMPTY_STRING).length(); //$NON-NLS-1$
	        else
	            lineLen += word.length();
	    }

	    return output.toString();
	}
}
