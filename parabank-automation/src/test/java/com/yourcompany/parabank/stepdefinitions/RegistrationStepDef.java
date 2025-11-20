package com.yourcompany.parabank.stepdefinitions;
import com.microsoft.playwright.*;
import io.cucumber.java.en.*;
import playwrightbdd.stepdefinitions.CommonSteps;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class RegistrationStepDef {
    Page page = CommonSteps.page;
    
    Properties locators = new Properties();
    public RegistrationStepDef() {
        try {
        	locators.load(new FileInputStream("src/test/resources/locators.properties"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config or locator files");
        }
    }
    @When("user clicks on Register option")
    public void clickRegisterOption() {
        page.click(locators.getProperty("registerLink"));
    }

    @When("user enters all the mandatory details")
    public void enterDetailsAndRegister() {
        String dynamicUser = "user" + System.currentTimeMillis();
        String dynamicPass = "Password123";
        saveGeneratedCredentials(dynamicUser, dynamicPass);
        page.fill(locators.getProperty("first_name"), "Sai");
        page.fill(locators.getProperty("last_name"), "Shankar");
        page.fill(locators.getProperty("address"), "Hyderabad");
        page.fill(locators.getProperty("city"), "Hyderabad");
        page.fill(locators.getProperty("state"), "TG");
        page.fill(locators.getProperty("Zip_code"), "500001");
        page.fill(locators.getProperty("phone_Number"), "9876543210");
        page.fill(locators.getProperty("SSN"), "123456");
        
//        String uniqueUser = "saiUser" + System.currentTimeMillis();
        page.fill(locators.getProperty("username_registration"), dynamicUser);
        page.fill(locators.getProperty("password_registration"), dynamicPass);
        page.fill(locators.getProperty("confirm_Password"), dynamicPass);
        
    }
    
    @And("user submits the registration form")
    public void user_submits_the_registration_form() {
 	   page.click(locators.getProperty("registerButton"));
    }

    @Then("user gets success message")
    public void verifySuccess() throws InterruptedException  {

        // Verification
        page.waitForSelector(locators.getProperty("successmessage"));

        System.out.println("Registration Successful!");
        
      Thread.sleep(3000);

    }
    private void saveGeneratedCredentials(String username, String password) {
        try (FileOutputStream out =
                     new FileOutputStream("src/test/resources/generated/generatedData.properties")) {

            Properties props = new Properties();
            props.setProperty("username", username);
            props.setProperty("password", password);
            props.store(out, "Generated user credentials");

            System.out.println("Saved generated credentials → " + username);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save generated credentials");
        }
    }
}
