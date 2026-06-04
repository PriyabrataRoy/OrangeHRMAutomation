package stepdefinations;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.PIMPage;

public class OrangeHRMPIMSteps extends BaseTest {

    LoginPage loginPage;
    PIMPage pimPage;

    @Given("User logs into OrangeHRM")
    public void userLogsIntoOrangeHRM() {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        pimPage = new PIMPage(driver);
    }

    @When("User navigates to PIM module")
    public void navigateToPIM() {

        pimPage.clickPIM();
    }

    // ==========================
    // Add Employee
    // ==========================

    @When("User adds a new employee")
    public void addEmployee() throws InterruptedException {

        pimPage.clickAddEmployee();

        pimPage.addEmployeeDetails("Employee", "KumarSingh");
        
        Thread.sleep(3000);
        pimPage.clickSave();
    }

    @Then("Employee should be added successfully")
    public void employeeAddedSuccessfully() throws InterruptedException {

        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("pim"));
    }

    // ==========================
    // Search Employee
    // ==========================

    @When("User searches employee by ID")
    public void userSearchesEmployeeByID() {

        pimPage.clickEmployeeList();

        pimPage.enterEmployeeId("0410");

        pimPage.clickSearch();
    }

    @Then("Employee record should be displayed")
    public void employeeRecordShouldBeDisplayed() {

        Assert.assertTrue(pimPage.isEmployeeDisplayed());
    }

    // ==========================
    // Edit Employee
    // ==========================

    @When("User edits employee details")
    public void userEditsEmployeeDetails() throws InterruptedException {

        pimPage.clickEmployeeList();

        Thread.sleep(2000);

        pimPage.clickEditEmployee();

        Thread.sleep(2000);

        pimPage.updateLastName("Updated");
        
        Thread.sleep(3000);
        pimPage.clickSave();
    }

    @Then("Employee details should be updated")
    public void employeeDetailsShouldBeUpdated() {

        Assert.assertTrue(
                driver.getCurrentUrl().contains("viewPersonalDetails"));
    }
 // ==========================
 // Upload Employee Picture
 // ==========================

    @When("User uploads employee profile picture")
    public void userUploadsEmployeeProfilePicture() throws InterruptedException {

        pimPage.clickEmployeeList();

        Thread.sleep(2000);

        pimPage.clickEditEmployee();

        Thread.sleep(2000);

        pimPage.clickProfileImage();

        Thread.sleep(5000);

        System.out.println("URL AFTER CLICK = " + driver.getCurrentUrl());

        pimPage.uploadEmployeePhoto(
                "C:\\Users\\rpriy\\OneDrive\\Desktop\\Final\\Xpd\\OrangeHRMAutomation\\ImageOfProfilePhoto\\Profiledemo2.png");

        Thread.sleep(5000);

        pimPage.clickSave();

        Thread.sleep(3000);
    }

    @Then("Profile picture should be uploaded successfully")
    public void profilePictureShouldBeUploadedSuccessfully() {

        Assert.assertTrue(
                driver.getCurrentUrl().contains("viewPhotograph"));
    }
    
 // ==========================
 // Delete Employee
 // ==========================

 @When("User deletes employee record")
 public void userDeletesEmployeeRecord() throws InterruptedException {

     pimPage.clickEmployeeList();

     Thread.sleep(2000);

     pimPage.clickDeleteEmployee();

     Thread.sleep(2000);

     pimPage.clickConfirmDelete();

     Thread.sleep(3000);
 }

 @Then("Employee should be deleted successfully")
 public void employeeShouldBeDeletedSuccessfully() {

     Assert.assertTrue(
             driver.getCurrentUrl().contains("viewEmployeeList"));
 }
}