class LoginPage {

  constructor(page) {
    this.page = page;
    this.usernameField = "input[name='username']";
    this.passwordField = "input[name='password']";
    this.loginButton = "button[type='submit']";
    this.dashboardHeader = "h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-level-1";

  }

  async navigateToLogin() {
    await this.page.goto("https://opensource-demo.orangehrmlive.com/");
  }

  async login(username, password) {
    await this.page.fill(this.usernameField, username);
    await this.page.fill(this.passwordField, password);
    await this.page.click(this.loginButton);
  }

  async isDashboardVisible() {
  await this.page.waitForSelector(this.dashboardHeader, { timeout: 20000 });
  return this.page.isVisible(this.dashboardHeader);
}

}

module.exports = LoginPage;
