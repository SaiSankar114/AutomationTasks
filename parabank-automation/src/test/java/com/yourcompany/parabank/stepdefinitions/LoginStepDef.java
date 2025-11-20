package com.yourcompany.parabank.stepdefinitions;
import com.microsoft.playwright.*;
import io.cucumber.java.en.*;
import playwrightbdd.stepdefinitions.CommonSteps;

import java.io.FileInputStream;
import java.util.Properties;


public class LoginStepDef {
    Page page = CommonSteps.page;
    
    Properties locators = new Properties();
    Properties generatedData = new Properties();
    
    public LoginStepDef() {
        try {
        	locators.load(new FileInputStream("src/test/resources/locators.properties"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config or locator files");
        }
    }
    @And ("user enters login credentials")
    public void user_enters_login_credentials() {
    	
    	String username = generatedData.getProperty("username");
    	String password = generatedData.getProperty("password");
    	
    	page.fill(locators.getProperty("login_username"),username);
    	page.fill(locators.getProperty("login_password"),password);
    }
    
    @And ("user clicks Login button")
    public void user_clicks_Login_button() {
    	page.click(locators.getProperty("login_button"));
    }
    
    @Then ("user should see Accounts Overview page")
    public void user_should_see_Accounts_Overview_page() {
    	page.waitForSelector(locators.getProperty("Account_overView"));
    }
    
}

