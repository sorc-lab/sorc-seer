package seer;

import java.io.IOException;

public abstract class AbstractHarvester {
	protected static String linkText_;
	protected static String[] paragraphs_;
	protected HarvesterIO io_;
	
	protected AbstractHarvester(String rootDir, String fileExt) {
		io_ = new HarvesterIO(rootDir, fileExt);
	}
	
	protected void performHarvesterIO_() throws Exception {
		try {			
			io_.createDirectoryFromLinkText(linkText_);
			io_.createTextFileFromLinkText(linkText_);
			io_.writeToFile(linkText_, paragraphs_);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	abstract public void harvest() throws Exception;
}
