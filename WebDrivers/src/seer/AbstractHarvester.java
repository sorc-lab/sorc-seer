package seer;

import java.io.IOException;

public abstract class AbstractHarvester {
	private String _rootDir;
	private String _fileExt;
	protected static String linkText_;
	protected static String[] paragraphs_;
	
	public AbstractHarvester(String rootDir, String fileExt) {
		this._rootDir = rootDir;
		this._fileExt = fileExt;
	}
	
	public String getRootDir() { return _rootDir; }
	public String getFileExt() { return _fileExt; }
	
	protected void performHarvesterIO_() throws Exception {
		try {
			HarvesterIO.createDirectoryFromLinkText(_rootDir, linkText_);
			HarvesterIO.createTextFileFromLinkText(_fileExt, linkText_);
			HarvesterIO.writeToFile(linkText_, paragraphs_);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	abstract public void harvest() throws Exception;
}
