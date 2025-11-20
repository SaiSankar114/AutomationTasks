package com.yourcompany.parabank.pages;

import com.microsoft.playwright.Page;
import com.yourcompany.parabank.utils.ConfigReader;
import com.yourcompany.parabank.utils.LocatorReader;

public class LoginPage {

    private Page page;
    
    public LoginPage(Page page) {
        this.page = page;
        LocatorReader.initLocators();
    }
    
    public void launchApplication() {
    	  ConfigReader.initProperties();
          LocatorReader.initLocators();
          
          page.navigate(ConfigReader.get("url"));
          
    }
    public void enterCredentials(
    		String Username,
    		String Password
    		) 
    {
    	page.fill(LocatorReader.get("Username"),Username);
    	page.fill(LocatorReader.get("Password"),Password);
    }
    
    public void click_login() {
    	
    }

}
