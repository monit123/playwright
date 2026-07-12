package TestCases;

import java.io.IOException;

import Base.BaseTest;
import Pages.loginPage;
import Utils.BrowserActions;

public class RegisterUser extends BaseTest {
	public RegisterUser() {
		
	}
	
	public void registerUser() throws IOException {
		BrowserActions browserActions=new BrowserActions(this.page);
		loginPage loginpage=new loginPage(this.page);
		browserActions.launchBrowser();
		
	}
}
