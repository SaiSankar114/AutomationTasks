const { Given, When, Then } = require("@cucumber/cucumber");
const LoginPage = require("../pages/LoginPage");
const { expect } = require("@playwright/test");

Given("the user is on the OrangeHRM login page", { timeout: 60000 }, async function () {
  this.loginPage = new LoginPage(this.page);
  await this.loginPage.navigateToLogin();
});

When("the user enters valid username and password", async function () {
  await this.loginPage.login("Admin", "admin123");
});

;
