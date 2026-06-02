package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumUtilities.ReusableFunctions;

public class LoginPage {

    WebDriver driver;
    ReusableFunctions rf;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rf = new ReusableFunctions(driver);
    }

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[contains(@class,'oxd-alert-content')]")
    WebElement invalidMessage;

    @FindBy(xpath = "//span[text()='Required']")
    WebElement requiredMessage;

    public void enterUsername(String username) {
        rf.insertText(txtUsername, username);
    }

    public void enterPassword(String password) {
        rf.insertText(txtPassword, password);
    }

    public void clickLogin() {
        rf.clickElement(btnLogin);
    }

    public String getInvalidMessage() {
        rf.waitTime(invalidMessage);
        return invalidMessage.getText();
    }

    public String getRequiredMessage() {
        rf.waitTime(requiredMessage);
        return requiredMessage.getText();
    }

    public boolean isUsernameDisplayed() {
        rf.waitTime(txtUsername);
        return txtUsername.isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        rf.waitTime(txtPassword);
        return txtPassword.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        rf.waitTime(btnLogin);
        return btnLogin.isDisplayed();
    }
}