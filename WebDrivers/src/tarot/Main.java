package tarot;

import java.io.IOException;

public class Main extends PhantomDriver
{
	
	
	public static void main(String[] args) throws Exception
	{
		PhantomDriver phantomDriver = new PhantomDriver();
		phantomDriver.initializePhantomDriver();
		
		ATADataHarvester ATADataHarvester = new ATADataHarvester();
		
		try {
			ATADataHarvester.harvest();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		/*
		HashMap<String, String[]> data = new HashMap<String, String[]>();
		
		// get all <p> within body of frame name="FRB"
		List<WebElement> elems = driver.findElements(By.tagName("p"));
		int cnt = elems.size();
		String[] dataTxt = new String[cnt];
		
		int i = 0;
		for (WebElement elem : elems) {
			//System.out.println(elem.getText());
			dataTxt[i] = elem.getText();
			i++;
		}
				
		data.put("King of Swords", dataTxt);
		
		FileWriter fileWriter = new FileWriter("king_of_swords.txt");
		String newLine = System.getProperty("line.separator"); // more portable than '\n'
		
		for (i = 0; i < dataTxt.length; i++) {
			String tmp = getPreviewLines(dataTxt[i]);
			fileWriter.write(tmp + newLine);
			fileWriter.write(newLine);
		}
		fileWriter.close();
		*/
	}	
}
