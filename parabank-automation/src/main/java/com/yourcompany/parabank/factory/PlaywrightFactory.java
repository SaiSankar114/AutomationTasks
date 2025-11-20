package com.yourcompany.parabank.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Page initBrowser() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false) // change to true if you want headless
        );

        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public static void closeBrowser() {
        try {
            if (context != null) context.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
