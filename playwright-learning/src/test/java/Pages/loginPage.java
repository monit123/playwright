package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import Utils.BrowserActions;

public class loginPage {
	private Page page;
	private Locator username;
	private Locator password;
	private Locator loginBtn;
	private Locator login;
	public loginPage(Page page) {
		this.page=page;
		this.loginBtn=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login"));
		

		this.username=page.getByPlaceholder("Email Address");
		
		this.password=page.getByPlaceholder("Password");
		this.login=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
	}
	
	public void login() {
		loginBtn.click();
		username.fill("Admin");
		password.fill("admin123");
		BrowserActions.highlightElement(login);
		login.click();
	}
}
