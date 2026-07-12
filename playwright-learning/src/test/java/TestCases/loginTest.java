package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.BaseTest;
import Pages.HomePage;
import Pages.loginPage;
import Utils.BrowserActions;
import Utils.ReportUtils;

public class loginTest extends BaseTest{
	@Test
	public void loginTest1() throws IOException, InterruptedException {
		BrowserActions browserActions=new BrowserActions(this.page);
		loginPage loginpage=new loginPage(this.page);
		ReportUtils reportutils=new ReportUtils(this.page);
		HomePage homepage=new HomePage(this.page);
		browserActions.launchBrowser();
		reportutils.logStep("Navigated to URL", Status.INFO);
		homepage.validateHome();
		reportutils.logStep("Home page is displayed", Status.INFO);
		loginpage.login();
		reportutils.logStep("Login window is displayed", Status.INFO);
	}
}
