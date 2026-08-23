package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.BaseTest;
import Pages.HomePage;
import Pages.loginPage;
import Utils.BrowserActions;
import Utils.ReportUtils;

public class RegisterUser extends BaseTest {
	public RegisterUser() {
		
	}
	@Test
	public void registerUser() throws IOException {
		BrowserActions browserActions=new BrowserActions(this.page);
		loginPage loginpage=new loginPage(this.page);
		ReportUtils reportutils=new ReportUtils(this.page);
		HomePage homepage=new HomePage(this.page);
		browserActions.launchBrowser();
		reportutils.logStep("Navigated to URL", Status.INFO);
		homepage.validateHome();
		reportutils.logStep("Home page is displayed", Status.INFO);
		loginpage.signup();
		reportutils.logStep("Signup window is displayed", Status.INFO);
		loginpage.enterAccountInformation();
		reportutils.logStep("account info is entered", Status.INFO);
		loginpage.validateAccountCreated();
		reportutils.logStep("Account is created", Status.INFO);
	}
}
