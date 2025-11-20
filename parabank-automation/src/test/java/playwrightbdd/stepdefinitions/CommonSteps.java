package playwrightbdd.stepdefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.en.*;
import java.io.FileInputStream;
import java.util.Properties;

public class CommonSteps {

    public static Playwright playwright;
    public static Browser browser;
    public static Page page;
    public static Properties config = new Properties();

    static {
        try {
            config.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    @Given("user launches the browser")
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
    }

    @And("user navigate to parabank application")
    public void navigateApplication() {
        page.navigate(config.getProperty("baseurl"));
    }
}
