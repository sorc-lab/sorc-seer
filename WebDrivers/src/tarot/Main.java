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
	}	
}
