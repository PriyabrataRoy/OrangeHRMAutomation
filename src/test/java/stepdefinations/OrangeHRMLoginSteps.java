package stepdefinations;

import org.testng.Assert;

import SeleniumUtilities.ReusableFunctions;
import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class OrangeHRMLoginSteps extends BaseTest {


    LoginPage loginPage;
    ReusableFunctions rf;

    @Given("User launches OrangeHRM application")
    public void launchApplication() {

        loginPage = new LoginPage(driver);

        rf = new ReusableFunctions(driver);

        rf.setExcel(
                "src/test/resources/Excelsheets/Exceltestsheet.xlsx",
                "LoginCredentials");
    }

    @When("User enters valid username and valid password")
    public void validLogin() {

        loginPage.enterUsername(rf.getCellData(4, 0));
        loginPage.enterPassword(rf.getCellData(4, 1));
        rf.TakeScreenshot("Valid_Credentials_Entered");
    }

    @When("User enters invalid username and valid password")
    public void invalidUsername() {

        loginPage.enterUsername(rf.getCellData(1, 0));
        loginPage.enterPassword(rf.getCellData(1, 1));
        
        rf.TakeScreenshot("InValid_UserName_Entered");
    }

    @When("User enters valid username and invalid password")
    public void invalidPassword() {

        loginPage.enterUsername(rf.getCellData(2, 0));
        loginPage.enterPassword(rf.getCellData(2, 1));
        
        rf.TakeScreenshot("InValid_password_Entered");
    }

    @When("User clicks Login button")
    public void clickLogin() {

        loginPage.clickLogin();
    }

    @Then("User should be navigated to dashboard")
    public void verifyDashboard() throws InterruptedException {

        Thread.sleep(3000);
        rf.TakeScreenshot("Dashboard_Page_Verified");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("dashboard"));
    }
    
    @Then("User should see invalid credential error")
    public void verifyInvalidMessage() throws InterruptedException {
    	Thread.sleep(2500);
    	rf.TakeScreenshot("Invalid_Credentials_Error_Screen");
    	
        Assert.assertTrue(
                loginPage.getInvalidMessage().contains("Invalid"),
                "Invalid credential message not displayed");
    }

    @Then("User should see required field validation")
    public void verifyRequiredMessage() {
    	
    	rf.TakeScreenshot("Required_Field_Validation_Screen");
    	
        Assert.assertEquals(
                loginPage.getRequiredMessage(),
                "Required");
    }

    @Then("Verify login page elements are displayed")
    public void verifyUIElements() {

        Assert.assertTrue(loginPage.isUsernameDisplayed());

        Assert.assertTrue(loginPage.isPasswordDisplayed());

        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        
        rf.TakeScreenshot("Login_UI_Elements_Checked");
    }


	
	
}

