package stepdefinations;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.LogoutPage;

public class OrangeHRMLogoutSteps extends BaseTest {

    LoginPage loginPage;
    LogoutPage logoutPage;

    @Given("User logs into OrangeHRM for Logout")
    public void userLogsIntoOrangeHRMForLogout() throws InterruptedException {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Thread.sleep(5000);

        logoutPage = new LogoutPage(driver);
    }

    @When("User logs out from application")
    public void userLogsOutFromApplication() throws InterruptedException {

        Thread.sleep(5000);

        logoutPage.clickProfileDropdown();

        Thread.sleep(2000);

        logoutPage.clickLogout();

        Thread.sleep(3000);
    }

    @Then("User should be redirected to login page")
    public void userShouldBeRedirectedToLoginPage() {

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"));
    }

    @When("User clicks browser back button")
    public void userClicksBrowserBackButton() throws InterruptedException {

        driver.navigate().back();

        Thread.sleep(3000);

        System.out.println("URL AFTER BACK = " + driver.getCurrentUrl());
    }

    @Then("User should not access application without login")
    public void userShouldNotAccessApplicationWithoutLogin() {

        driver.navigate().refresh();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"));
    }
}