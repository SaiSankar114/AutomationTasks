package testAutomationTasks;
import com.microsoft.playwright.Browser;
import static org.junit.Assert.assertTrue;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class Herokuapp_HandlingAndAuth {

	public static void main(String[] args) {
//		Launching the heroku.com
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://id.heroku.com/login");
            System.out.println("Page title: " + page.title());
            Locator username = page.locator("//input[@name='email']"); //Xpath
            Locator password= page.locator("#password");//CSS
            username.fill("saishankar039@gmail.com");
            password.fill("HelloBro");
            Locator errorMessage=page.locator("text=There was a problem with your login.");
            System.out.println(errorMessage);
            username.clear();
            username.fill("saishankar039@gmail.com");
            password.fill("Kickstart@2025A123");
            
            page.locator("//button[@name='commit']").click();
//            After login
          Locator message = page.locator("text=Secure Your Account");
          System.out.println(message);
          assertTrue("Visable message",message.isVisible());
          

          

	}

}

	
}
