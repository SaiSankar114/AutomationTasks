package testAutomationTasks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Wikkipedia_DynamicContent {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.wikipedia.org/");
            System.out.println("Page title: " + page.title());
            Locator term = page.locator("//div[@class='central-textlogo']");
           term.waitFor();
           System.out.println(term.textContent());
//            Handling dynamic handling of results
//           We can use by Waitfor elemet to apper, wait for element to visable( .tobevisable) and also
//           wait for text to change also. Please suggest me if any other option there

	}

}
}