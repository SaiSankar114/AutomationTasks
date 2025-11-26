class adminPage{
    constructor(adminPage){
        this.page = page;
        this.adminBtn="//a[@class='oxd-main-menu-item active']//span[text()='Admin']";
        this.addBtn="//div[@class='orangehrm-header-container']//i";
        this.userRole="//div[@class='oxd-select-text oxd-select-text--active']";
        this.employeeName="//input[@placeholder='Type for hints...']";
        this.employeeNameOption="//div[@role='listbox']//*[text()='Saige  John Fuentes']";
        this.username="//input[@name='username']";
        this.password="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']";
        this.confirmPassword="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group']";
        this.saveBtn="//button[@type='submit']";
        this.usernameResult="//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']";
        this.searchBtn="//button[@type='submit']";
        this.userResult="//div[@class='oxd-table-card']";
        this.statusDropdown="//div[@class='oxd-select-text oxd-select-text--active']";
        this.statusOption="//div[@role='listbox']//*[text()='Enabled']";
    }
     async navigateToAdmin(){
            await this.page.click(this.adminBtn);
        }   
async addUserDetails(){
    await this.page.click(this.addBtn);
    await this.page.click(this.addBtn);
    await this.page.click(this.userRole);
    await this.page.click("//span[contains(text(),'Admin')]");
    await this.page.click(this.statusDropdown);
    await this.page.click(this.statusOption);
    await this.page.fill(this.employeeName,"Sai");
    await this.page.click(this.employeeNameOption);
    await this.page.fill(this.username,"Sai123");
    await this.page.fill(this.password,"Sai@1234");
    await this.page.fill(this.confirmPassword,"Sai@1234");
    await this.page.click(this.saveBtn);
}
async userSearch(){
    await this.page.fill(this.usernameResult,"Sai123");
    await this.page.click(this.searchBtn);
    await this.page.waitForSelector(this.userResult,{timeout:60000});
    return this.page.isVisible(this.userResult);
    console.log("User added successfully"); 
}


}