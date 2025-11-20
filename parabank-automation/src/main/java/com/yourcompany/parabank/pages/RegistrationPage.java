package com.yourcompany.parabank.pages;

import com.microsoft.playwright.Page;
import com.yourcompany.parabank.utils.LocatorReader;

public class RegistrationPage {

    private Page page;

    public RegistrationPage(Page page) {
        this.page = page;
        LocatorReader.initLocators();
    }

    public void openRegistrationPage() {
        page.click(LocatorReader.get("registerLink"));
    }

    public void enterRegistrationDetails(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phone,
            String ssn,
            String username,
            String password
    ) {
        page.fill(LocatorReader.get("firstNameInput"), firstName);
        page.fill(LocatorReader.get("lastNameInput"), lastName);
        page.fill(LocatorReader.get("addressInput"), address);
        page.fill(LocatorReader.get("cityInput"), city);
        page.fill(LocatorReader.get("stateInput"), state);
        page.fill(LocatorReader.get("zipCodeInput"), zip);
        page.fill(LocatorReader.get("phoneInput"), phone);
        page.fill(LocatorReader.get("ssnInput"), ssn);
        page.fill(LocatorReader.get("regUsernameInput"), username);
        page.fill(LocatorReader.get("regPasswordInput"), password);
        page.fill(LocatorReader.get("confirmPasswordInput"), password);
    }

    public void submitForm() {
        page.click(LocatorReader.get("registerButton"));
    }

    public boolean isRegistrationSuccessful() {
        return page.isVisible(LocatorReader.get("registrationSuccessMsg"));
    }
}
