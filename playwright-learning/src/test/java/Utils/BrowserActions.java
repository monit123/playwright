package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Base.BaseTest;

public class BrowserActions {
	private Page page;
	public BrowserActions(Page page) {
		this.page=page;
	}
	
	public void launchBrowser() throws IOException {
		String url=configReader("URL");
		page.navigate(url);
	}
	
	public String configReader(String key) throws IOException {
		final Properties props = new Properties();
//		String projdir=System.getProperty("user.dir");
//		String path=projdir+"/config.properties";
//		FileInputStream fis=new FileInputStream(path);
		InputStream input=BrowserActions.class.getClassLoader().getResourceAsStream("config.properties");
		props.load(input);
		return props.getProperty(key);
	}
	
}
