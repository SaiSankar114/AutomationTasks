package testAutomationTasks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class locatorsHandlingNavigationandValidation {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.amazon.in/");
            String actualPage = page.title();
            System.out.println("Page title: " + actualPage);

//        	Task2: Can you navigate and check specific element is visible
//        	I am locating it using below selectors:
//            Using Xpath"://div[@id='nav-cart-count-container']
            Locator  cart=  page.locator("//div[@id='nav-cart-count-container']");
            cart.click();
//            CSS:#nav-cart-count-container
//			  Using visable text"
//            page.locator("text=cart")
	}

}
}
