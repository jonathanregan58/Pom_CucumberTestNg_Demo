package com.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.actions.HomePageActions;
import com.example.actions.LoginPageActions;
import com.example.utils.HelperClass;



import org.testng.Assert;
 
public class LoginPageDefinitions {
 
    LoginPageActions objLogin = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();
 
    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
 
        HelperClass.openPage(url);
 
    }
 
    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
 
        // login to application
        objLogin.login(userName, passWord);
 
        // go the next page
 
    }
 
    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
 
        // Verify home page
        //Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
     //   Assert.assertEquals(objHomePage.getHomePageText(), "Dashboard");
       // System.out.println(objHomePage.getHomePageText());
    	
        // Assert.assertEquals(objHomePage.getURLHomePage(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
 
    }
    
    @Then("User should be able to be on home page")
    public void user_should_be_able_to_be_on_home_page() {
    	Assert.assertEquals(objHomePage.getURLHomePage(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
 
    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
 
        // Verify home page
        Assert.assertEquals(objLogin.getErrorMessage(),expectedErrorMessage);
        System.out.println("Berhasil");
 
    }
 
    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {
 
        Assert.assertEquals(objLogin.getMissingUsernameText(),message);
    }
 
}
