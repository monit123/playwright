package Pages;

import org.assertj.core.api.Assertions;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import Utils.BrowserActions;
import Utils.CommonUtils;
import Utils.ReportUtils;

public class loginPage {
	private Page page;
	private Locator username;
	private Locator password;
	private Locator loginBtn;
	private Locator login;
	private Locator name;
	private Locator email;
	private Locator signupBtn;
	private Locator selectGender;
	private Locator newPassword;
	private Locator date;
	private Locator month;
	private Locator year;
	private Locator firstName;
	private Locator lastName;
	private Locator company;
	private Locator address;
	private Locator state;
	private Locator city;
	private Locator zipcode;
	private Locator MobileNumber;
	private Locator createAccountBtn;
	private Locator accountCreatedMessage;
	ReportUtils reportUtils=new ReportUtils(page);
	
	public loginPage(Page page) {
		this.page=page;
		this.loginBtn=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login"));
		this.username=page.locator("[data-qa='login-email']");
		this.password=page.getByPlaceholder("Password");
		this.login=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
		this.name=page.getByPlaceholder("Name");
		this.email=page.locator("[data-qa='signup-email']");
		this.signupBtn=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Signup"));
		this.selectGender=page.getByLabel("Mr.");
		this.newPassword=page.locator("[data-qa='password']");
		this.date=page.locator("#days");
		this.month=page.locator("#months");
		this.year=page.locator("#years");
		this.firstName=page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("First name *"));
		this.lastName=page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Last name *"));
		this.company=page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Company").setExact(true));
		this.address=page.getByRole(
			    AriaRole.TEXTBOX,
			    new Page.GetByRoleOptions().setName("Address * (Street address, P.")
			);
		this.state=page.getByRole(
			    AriaRole.TEXTBOX,
			    new Page.GetByRoleOptions().setName("State *")
			);
		this.city=page.locator("#city");
		this.zipcode=page.locator("#zipcode");
		this.MobileNumber=page.locator("#mobile_number");
		this.createAccountBtn=page.locator("[data-qa='create-account']");
		this.accountCreatedMessage=page.locator("//b[text()='Account Created!']");
	}
	
	public void login() {
		loginBtn.click();
		username.fill("Admin");
		password.fill("admin123");
		BrowserActions.highlightElement(login);
		login.click();
	}
	
	public void signup() {
		loginBtn.click();
		name.fill("Monit");
		String randomEmail=CommonUtils.randomStringGenerator(9)+String.valueOf(CommonUtils.randomDigitGenerator(8)+"@gmail.com");
		email.fill(randomEmail);
		signupBtn.click();
	}
	
	public void enterAccountInformation() {
		selectGender.check();
		newPassword.fill("Monit@123");
		date.selectOption("15");
		month.selectOption("March");
		year.selectOption("1998");
		firstName.click();
		firstName.fill("Monit");
		lastName.click();
		lastName.fill("Gupta");
		company.click();
		company.fill("Automation");
		address.click();
		address.fill("Eco village 2");
		state.click();
		state.fill("UP");
		city.click();
		city.fill("Noida");
		zipcode.click();
		zipcode.fill("201302");
		MobileNumber.click();
		String randomNumber=String.valueOf(CommonUtils.randomDigitGenerator(9)+1);
		MobileNumber.fill(randomNumber);
		createAccountBtn.click();
	}
	
	public void validateAccountCreated() {
		if(accountCreatedMessage.isVisible()) {
			BrowserActions.highlightElement(accountCreatedMessage);
		}
	}
}
