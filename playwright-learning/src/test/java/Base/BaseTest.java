package Base;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
	protected static Playwright playwright;
	protected static Browser browser;
	protected BrowserContext context ;
	protected Page page;
	
	@BeforeSuite
	public void globalSetup() {
		playwright=Playwright.create();
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
	}
	
	@BeforeMethod
	public void testSetup() {
		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null)
				);
		page=context.newPage();
	}
	
	@AfterMethod
	public void testTeardown() {
		context.close();
	}
	
	@AfterSuite
	public void globalTeardown() {
		playwright.close();
		browser.close();
	}
	
}
