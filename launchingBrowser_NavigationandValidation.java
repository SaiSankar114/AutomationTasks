package testAutomationTasks;
import com.microsoft.playwright.*;
import static org.junit.Assert.assertEquals;



public class launchingBrowser_NavigationandValidation {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://example.com");
            String actualPage = page.title();
            System.out.println("Page title: " + actualPage);
            
//            Q:1: What happen if title doesn't match how do you handle
//            A: As part of testing it will throw the error and test will fail,
//            to check this I will write assert class and check that please find below.
           String expectedTittle= "Example Domain";
        assertEquals("Tittle is",expectedTittle,actualPage); 
//           
        }
    }
}






