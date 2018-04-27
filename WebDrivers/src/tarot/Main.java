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
			
			// com.sorclab.PhantomDriver
			// 		(instantiates driver + exposes publicly)
			//		*May need an interface some day
			//
			// com.sorclab.Helper
			//		(currently supports common WebDriver actions,
			//		 i.e. getPresentWebElement(By locator))
			//
			// com.sorclab.DataHarvester (???)
			//
			// com.sorclab.Navigator (interface)
			// com.sorclab.tarot.FileGenerator (interface)
			//
			// com.sorclab.tarot.ATA.FileGenerator
			// com.sorclab.tarot.ATA.Navigator
			// com.sorclab.tarot.ATA.DataHarvester
			//
			// com.sorclab.tarot.TT.FileGenerator
			// com.sorclab.tarot.TT.Navigator
			// com.sorclab.tarot.TT.DataHarvester
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
