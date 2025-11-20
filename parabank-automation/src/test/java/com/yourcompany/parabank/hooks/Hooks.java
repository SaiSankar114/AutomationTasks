package com.yourcompany.parabank.hooks;

import com.microsoft.playwright.Page;
import com.yourcompany.parabank.factory.PlaywrightFactory;
import com.yourcompany.parabank.utils.ConfigReader;
import com.yourcompany.parabank.utils.LocatorReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static Page page;

    @Before
    public void setup() {
        ConfigReader.initProperties();   // ADD THIS
        LocatorReader.initLocators();    // Optional but good practice
        page = PlaywrightFactory.initBrowser();
        System.out.println("Browser launched before scenario");
    }


    @After
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
        System.out.println("Browser closed after scenario");
    }
}
