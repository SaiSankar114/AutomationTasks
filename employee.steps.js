const{When,Then}=require("@cucumber/cucumber");
const EmployeePage = require("../pages/EmployeePage");
const {expect}=require("@playwright/test");

When("user navigate PIM and clicks add option",async function(){
    this.EmployeePage = new EmployeePage (this.page);
    await this.EmployeePage.navigateToPIM();
});
When("user enters mandatory details and save the details",async function(){
    await this.EmployeePage.addEmployeeDetails();

})
Then ("user captures the username",{ timeout: 60000 },async function(){
await this.EmployeePage.isEmployeeAdded();

})
  
