package seer;

import java.io.IOException;

public abstract class AbstractHarvester {
	protected HarvesterIO io_;
	protected String linkText_;
	protected String[] paragraphs_;
	
	protected AbstractHarvester(String rootDir, String fileExt) {
		io_ = new HarvesterIO(rootDir, fileExt);
	}
	
	abstract public void harvest() throws Exception;
	
	protected void performHarvesterIO_() throws Exception {
		try {
			io_.createDirectoryFromLinkText(linkText_);
			io_.createTextFileFromLinkText(linkText_);
			io_.writeToFile(linkText_, paragraphs_);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
