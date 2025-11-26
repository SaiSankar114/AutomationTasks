const{When,Then}=require("@cucumber/cucumber");
const EmployeePage = require("../pages/EmployeePage");
const {expect}=require("@playwright/test");
When("user navigate admin and clicks add option",{ timeout: 60000 },async function(){
    this.adminPage = new adminPage (this.page);
    await this.adminPage.navigateToAdmin();
    })
When("user enters mandatory user details and save the details",async function(){
    await this.adminPage.addUserDetails();
})
Then ("user search for added user",{ timeout: 60000 },async function(){
await this.adminPage.userSearch();
})
