package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class loginPage {
	private Page page;
	private Locator username;
	private Locator password;
	private Locator loginBtn;
	public loginPage(Page page) {
		this.page=page;
		this.username=page.getByPlaceholder("Username");
		this.password=page.getByPlaceholder("Password");
		this.loginBtn=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
		//this.loginBtn=page.getByText("Login");
	}
	
	public void login() {
		username.fill("Admin");
		password.fill("admin123");
		loginBtn.click();
	}
}
