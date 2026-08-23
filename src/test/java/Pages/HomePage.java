package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import Utils.BrowserActions;

public class HomePage {
	private Page page;
	private Locator homeIcon;
	
	public HomePage(Page page) {
		this.page=page;
		this.homeIcon=page.getByAltText("Website for automation practice");
	}

	public void validateHome() {
		if(homeIcon.isVisible()) {
		BrowserActions.highlightElement(homeIcon);
		}
	}
	
	
}
