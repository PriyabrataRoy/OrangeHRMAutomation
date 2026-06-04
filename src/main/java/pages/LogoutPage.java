package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumUtilities.ReusableFunctions;

public class LogoutPage {

    WebDriver driver;
    ReusableFunctions rf;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rf = new ReusableFunctions(driver);
    }

    // Profile dropdown
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement profileDropdown;

    // Logout link
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutButton;

    // Login page username field
    @FindBy(name = "username")
    WebElement usernameField;

    public void clickProfileDropdown() {
        rf.waitTime(profileDropdown);
        rf.clickElement(profileDropdown);
    }

    public void clickLogout() {
        rf.waitTime(logoutButton);
        rf.clickElement(logoutButton);
    }

    public boolean isLoginPageDisplayed() {
        rf.waitTime(usernameField);
        return usernameField.isDisplayed();
    }
}