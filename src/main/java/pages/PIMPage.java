package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumUtilities.ReusableFunctions;

public class PIMPage {

    WebDriver driver;
    ReusableFunctions rf;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rf = new ReusableFunctions(driver);
    }

    // PIM menu
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimMenu;

    // Add Employee tab
    @FindBy(xpath = "//a[text()='Add Employee']")
    WebElement addEmployee;

    // Employee List tab
    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement employeeListTab;

    // First Name
    @FindBy(name = "firstName")
    WebElement firstName;

    // Last Name
    @FindBy(name = "lastName")
    WebElement lastName;

    // Save button
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    // Employee ID Search field
    @FindBy(xpath = "(//label[text()='Employee Id']/../following-sibling::div/input)[1]")
    WebElement searchEmployeeId;

    // Search button
    @FindBy(xpath = "//button[contains(.,'Search')]")
    WebElement searchButton;

    // Search result table
    @FindBy(xpath = "//div[@class='oxd-table-body']")
    WebElement employeeRecord;

    // Edit button
    @FindBy(xpath = "(//i[contains(@class,'bi-pencil-fill')])[1]")
    WebElement editButton;

    // Editable Last Name field
    @FindBy(name = "lastName")
    WebElement lastNameField;

    // Profile Image Area
    @FindBy(xpath = "//div[contains(@class,'orangehrm-edit-employee-image')]")
    WebElement profileImage;
    
 // Delete button
    @FindBy(xpath = "(//i[contains(@class,'bi-trash')])[1]")
    WebElement deleteButton;

    // Confirm Delete button
    @FindBy(xpath = "//button[contains(.,'Yes, Delete')]")
    WebElement confirmDeleteButton;

    // ==========================
    // Navigation
    // ==========================

    public void clickPIM() {
        rf.clickElement(pimMenu);
    }

    public void clickAddEmployee() {
        rf.clickElement(addEmployee);
    }

    public void clickEmployeeList() {
        rf.clickElement(employeeListTab);
    }

    // ==========================
    // Add Employee
    // ==========================

    public void addEmployeeDetails(String fname, String lname) {
        rf.insertText(firstName, fname);
        rf.insertText(lastName, lname);
    }

    public void clickSave() {
        rf.clickElement(saveButton);
    }

    // ==========================
    // Search Employee
    // ==========================

    public void enterEmployeeId(String empId) {
        rf.insertText(searchEmployeeId, empId);
    }

    public void clickSearch() {
        rf.clickElement(searchButton);
    }

    public boolean isEmployeeDisplayed() {
        rf.waitTime(employeeRecord);
        return employeeRecord.isDisplayed();
    }

    // ==========================
    // Edit Employee
    // ==========================

    public void clickEditEmployee() {
        rf.clickElement(editButton);
    }

    public void updateLastName(String lname) {

        lastNameField.clear();

        rf.insertText(lastNameField, lname);
    }

    // ==========================
    // Upload Employee Photo
    // ==========================

    public void clickProfileImage() {

        rf.clickElement(profileImage);
    }

    public void uploadEmployeePhoto(String imagePath) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("input[type='file']")));

        driver.findElement(
                By.cssSelector("input[type='file']"))
                .sendKeys(imagePath);
    }
    
 // Click delete icon
    public void clickDeleteEmployee() {
        rf.clickElement(deleteButton);
    }

    // Confirm delete
    public void clickConfirmDelete() {
        rf.clickElement(confirmDeleteButton);
    }
}