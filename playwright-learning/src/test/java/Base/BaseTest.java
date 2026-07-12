package Base;

import java.nio.file.Paths;
import java.util.Arrays;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Utils.ExtentManager;
import groovyjarjarasm.asm.commons.Method;

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
	public void testSetup(java.lang.reflect.Method method) {
		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null)
				);
		page=context.newPage();
		ExtentTest test = ExtentManager.getInstance().createTest(method.getName());
        ExtentManager.setTest(test);
	}
	
	@AfterMethod
	public void testTeardown(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        ExtentManager.getTest().fail("Test failed: " +
	                (result.getThrowable() != null ? result.getThrowable().getMessage() : "Unknown error"));
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        ExtentManager.getTest().pass("Test completed successfully");
	    } else {
	        ExtentManager.getTest().skip("Test skipped");
	    }
	    context.close();
	}
	
	@AfterSuite
	public void globalTeardown() {
		ExtentManager.getInstance().flush();
		playwright.close();
		browser.close();
	}
	
}
