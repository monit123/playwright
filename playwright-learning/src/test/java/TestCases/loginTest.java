package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.loginPage;
import Utils.BrowserActions;

public class loginTest extends BaseTest{
	@Test
	public void loginTest1() throws IOException, InterruptedException {
		BrowserActions browserActions=new BrowserActions(this.page);
		loginPage loginpage=new loginPage(this.page);
		browserActions.launchBrowser();
		loginpage.login();
	}
}
