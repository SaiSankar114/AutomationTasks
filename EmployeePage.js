class EmployeePage{
    constructor(page){
    this.page = page;
    this.PIMmenu ="//li[@class='oxd-main-menu-item-wrapper'][2]";
    this.addEmployeebtn="//div[@class='orangehrm-header-container']/descendant::i";
    this.firstName="//input[@name='firstName']";
    this.lastname="//input[@name='lastName']";
    this.savebtn="//button[@type='submit']";
    this.employeeReslt="//div[@class='orangehrm-edit-employee']/descendant::h6[1]";
    }

async navigateToPIM(){
    await this.page.click(this.PIMmenu);
}
async addEmployeeDetails(){
    await this.page.click(this.addEmployeebtn);
    await this.page.fill( this.firstName,"Sai");
    await this.page.fill( this.lastname,"Sankar");
    await this.page.click(this.savebtn);
}
async isEmployeeAdded(){
    await this.page.waitForSelector(this.employeeReslt,{timeout:60000});
    return this.page.isVisible(this.employeeReslt);
}
async getEmployeeName() {
    await this.page.waitForSelector(this.employeeReslt, { timeout: 20000 });
    const name = await this.page.textContent(this.employeeReslt);
    return name.trim();
  }

    
}
module.exports = EmployeePage;