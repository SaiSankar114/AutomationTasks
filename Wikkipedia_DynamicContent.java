package testAutomationTasks;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import junit.framework.Assert;

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
// Assertion for content 
        assertThat(term).containsText("Wikipedia"); //here in this step I added the text verification 
        System.out.println("Verfication passed"); 
          
//            Handling dynamic handling of results
//           We can use by Waitfor element to appear, wait for element to visible( .tobevisible) and also
//           wait for text to change also. Please suggest me if any other option there
	}
}
}