package seer.tt;

import org.openqa.selenium.WebDriver;

import seer.AbstractHarvester;

public class TTHarvester extends AbstractHarvester {
	private WebDriver _driver;

	public TTHarvester(WebDriver driver) {
		super("TTTarot", "_tt.txt");
		this._driver = driver;
	}

	@Override
	public void harvest() throws Exception {
		
	}
}
